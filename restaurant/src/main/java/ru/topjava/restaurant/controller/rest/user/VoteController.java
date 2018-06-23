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

import ru.topjava.restaurant.model.*;
import ru.topjava.restaurant.repository.DishRepository;
import ru.topjava.restaurant.repository.RestaurantMenuRepository;
import ru.topjava.restaurant.repository.RestaurantRepository;
import ru.topjava.restaurant.repository.VoteHistoryRepository;
import ru.topjava.restaurant.service.DishService;
import ru.topjava.restaurant.service.VoteService;
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
    private DishRepository dishRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantMenuRepository restaurantMenuRepository;

    @Autowired
    private VoteHistoryRepository voteHistoryRepository;

    @Autowired
    private DishService dishService;

    @Autowired
    private VoteService voteService;

    //голосование за ресторан по id
    @GetMapping("/restaurants/{id}/increase")
    public String get(@PathVariable("id") long id) {
        log.info("Vote user for restaurant {}", id);
        return voteService.voteForRestaurant(id);
    }

    // было ли голосование сегодня
    public boolean isVoteToday() {
        log.info("whether there was a vote today");
        return voteService.isVoteToday();

    }

    //список блюд на сегодня для пользователя если ресторан единственный и у него всего одно меню
    @GetMapping("/dishesToday")
    public List<Dish> getDishesToday() {
        log.info("list of dishes for today");
        return dishService.getDishesToday();
    }

    //список блюд на сегодня для пользователя у конкретного ресторана
    @GetMapping("/restaurants/{id}/dishesToday")
    public List<RestaurantMenu> getDishesTodayForRestaurant(@PathVariable("id") long id) {
        log.info("list of dishes for today for restaurant {}", id);
        return dishService.getDishesTodayForRestaurant(id);
    }

    @GetMapping("/restaurants/{id}/dish/{dishId}/createDishTodayByRestaurant")
    public String createDishTodayForRestaurant(@PathVariable("id") long id,
                                                   @PathVariable("dishId") long dishId) {
        log.info("list of dishes for today for restaurant {}", id);
        // return dishRepository.getDishesForRestaurant();
        RestaurantMenu rm = new RestaurantMenu();
        rm.setCreatedDate(LocalDateTime.now());
        Restaurant restaurant = restaurantRepository.getOne(id);
        Dish dish = dishRepository.getOne(dishId);
        rm.setDish(dish);
        rm.setRestaurant(restaurant);
        restaurantMenuRepository.save(rm);
        return "Rest Menu create";

    }

    //добавление блюда на сегодня  тест
    @GetMapping("/dishAddToday")
    public void addDishToday() {
        Dish dish = new Dish();
      //  dish.setCreatedDate(LocalDateTime.now());
        dish.setName("milk");
        dish.setPrice(200.0);
        dishRepository.save(dish);
    }

/*    @GetMapping("/getuser")
    public String user() {
        SecurityContext context = SecurityContextHolder.getContext();
        return context.getAuthentication().getName();
    }

    @GetMapping("/getTopVote")
    public VoteHistory getTopVote() {
        return  voteHistoryRepository.findFirstByUsernameOrderByIdDesc("user");
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
    }*/
}

