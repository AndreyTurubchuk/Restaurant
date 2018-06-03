package ru.topjava.restaurant.controller.rest.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.topjava.restaurant.model.Dish;
import ru.topjava.restaurant.model.Restaurant;
import ru.topjava.restaurant.model.User;
import ru.topjava.restaurant.model.VoteHistory;
import ru.topjava.restaurant.repository.DishRepository;
import ru.topjava.restaurant.repository.RestaurantRepository;
import ru.topjava.restaurant.repository.VoteHistoryRepository;
import ru.topjava.restaurant.util.DateTimeUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping(value = "/user/rest/api/v1")
public class VoteController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private VoteHistoryRepository voteHistoryRepository;

    @GetMapping("/getuser")
    public String user() {
        SecurityContext context = SecurityContextHolder.getContext();
        String userName = context.getAuthentication().getName();
        return userName;
    }

    @GetMapping("/getTopVote")
    public VoteHistory getTopVote() {
        VoteHistory voteHistory = voteHistoryRepository.findFirstByUsernameOrderByIdDesc("user");
        return voteHistory;
    }


    @GetMapping("/getVote")
    public String getVote() {
        List<VoteHistory> voteHistories = voteHistoryRepository.findVoteHistoriesByUsername("user");
        for (VoteHistory voteHistory : voteHistories
                ) {
            long currentRaiting = voteHistory.getRestaurant().getRating();
            voteHistory.getRestaurant().setRating(currentRaiting + 1);
        }
        voteHistoryRepository.save(voteHistories);
        return "OK";
        //return voteHistoryRepository.findVoteHistoriesByUsername("user");
    }


    //голосование за ресторан по id
    @GetMapping("/restaurants/{id}/increase")
    public String get(@PathVariable("id") long id) {
        log.info("Vote user with restaurant {}", id);
        String result;
        Restaurant restaurant = restaurantRepository.findRestaurantByRestaurantId(id);
        LocalDateTime startTime = LocalDate.now().atTime(LocalTime.MIDNIGHT);
        LocalDateTime endTime = LocalDate.now().atTime(LocalTime.MAX);

        LocalTime startTimeDay = LocalTime.MIN;
        LocalTime endTimeDay = LocalTime.MAX;
        LocalTime voteEndTime = LocalTime.of(11, 0, 0);
        LocalTime current = LocalTime.now();

        if (restaurant == null) {
            log.error("Vote is impossible. Restaurant with id {} not found. ", id);
            return "Vote is impossible. Restaurant not found";
        }
        if (DateTimeUtil.isBetween(LocalTime.now(), voteEndTime, endTimeDay)) {
            result = "Голосование закрыто. Голосование возможно только с 00-00 до 11-00";
        } else {
            SecurityContext context = SecurityContextHolder.getContext();
            String userName = context.getAuthentication().getName();

            // уменьшение голоса у предыдущего ресторана
            VoteHistory voteHistoryLast = voteHistoryRepository.findFirstByUsernameOrderByIdDesc(userName);
            if (voteHistoryLast != null) {
                long currentRaitingLast = voteHistoryLast.getRestaurant().getRating() - 1;
                Restaurant restaurantLast = voteHistoryLast.getRestaurant();
                restaurantLast.setRating(currentRaitingLast);
                restaurantRepository.save(restaurantLast);
            }

            // увеличение голоса у текущего ресторана
            VoteHistory voteHistory = new VoteHistory();
            voteHistory.setRestaurant(restaurant);
            voteHistory.setUsername(userName);
            voteHistory.setDateTimeVote(LocalDateTime.now());
            voteHistoryRepository.save(voteHistory);
            long currentRaiting = restaurant.getRating() + 1;
            restaurant.setRating(currentRaiting);
            restaurantRepository.save(restaurant);
            result = "OK";
        }
        return result;
    }

    private static void restaurantSave(Restaurant restaurant) {

    }

    //добавление блюда на сегодня
    @GetMapping("/dishAddToday")
    public void addDishToday() {
        Dish dish = new Dish();
        dish.setCreatedDate(LocalDateTime.now());
        dish.setName("milk");
        dish.setPrice(200.0);
        dishRepository.save(dish);
    }

    //список блюд на сегодня для пользователя
    @GetMapping("/dishesToday")
    public List<Dish> getDishesToday() {
        LocalDateTime startTime = LocalDate.now().atTime(LocalTime.MIDNIGHT);
        LocalDateTime endTime = LocalDate.now().atTime(LocalTime.MAX);
        List<Dish> dishes = dishRepository.findAll();
        return dishes.stream()
                .filter(dish -> DateTimeUtil.isBetween(dish.getCreatedDate(), startTime, endTime))
                .collect(toList());
    }
}


/*            LocalTime nowTime = LocalTime.now();
            LocalTime startTimeDay = LocalTime.MIN;
            LocalTime endTimeDay = LocalTime.MAX;
            LocalTime voiteEndTime = LocalTime.of(11, 0, 0);*/
