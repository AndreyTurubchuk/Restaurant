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



    //голосование за ресторан по id
    @GetMapping("/restaurants/{restaurantId}/increase")
    // public String get(@PathVariable("restaurantId") long restaurantId,
    //                  @PathVariable("userId") long userId) {
    public String get(@PathVariable("restaurantId") long restaurantId) {
        log.info("Vote user with restaurant {}", restaurantId);
        //    LocalDateTime nowDay = LocalDateTime.now();
        LocalTime nowTime = LocalTime.now();
        LocalTime startTimeDay = LocalTime.MIN;
        LocalTime endTimeDay = LocalTime.MAX;

        LocalTime voiteEndTime = LocalTime.of(11, 0, 0);
        //LocalTime endTime2 = LocalTime.MAX;

        User user3 = new User();
        // user3.setEmail("ivan@rambler.ru");

        VoteHistory voteHistory = new VoteHistory();
        Restaurant restaurant = restaurantRepository.findRestaurantByRestaurantId(restaurantId);
        voteHistory.setRestaurant(restaurant);
        voteHistory.setUser(user3);
/*        voteHistory.setUser(user);
        voteHistoryRepository.save(voteHistory);*/
/*        if (DateTimeUtil.isBetween(nowDay, startTimeDay, endTimeDay)) { // если есть
            return "OK";
        } else {
            return
        }*/

            /*if (DateTimeUtil.isBetween(now, startTime2, endTime2)) {
            return "Vote is already finished. Vote is possible till 11-00";
            *//*Restaurant currentRestaurant = restaurantRepository.findRestaurantByRestaurantId(id);
            if (currentRestaurant == null) {
                log.error("Unable to voice. Restaurant with id {} not found. ", id);
                return "Error";
            } else {
                long currentRaiting = currentRestaurant.getRating();
                currentRaiting = currentRaiting + 1;
                currentRestaurant.setRating(currentRaiting);
                restaurantRepository.save(currentRestaurant);
                return "ОК";
            }*//*
        } else {
            List<VoteHistory> voteHistories =  voteHistoryRepository.findAll();
        }*/
        return "Time";
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

/*        List<Dish> dishesToday = new ArrayList<>();
        for (Dish dish : dishes
                ) {
            if (DateTimeUtil.isBetween(dish.getCreatedDate(), startTime, endTime)) {
                dishesToday.add(dish);
            }

        }*/