package ru.topjava.restaurant.controller.rest.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.topjava.restaurant.model.*;
import ru.topjava.restaurant.repository.DishRepository;
import ru.topjava.restaurant.repository.RestaurantMenuRepository;
import ru.topjava.restaurant.repository.RestaurantRepository;
import ru.topjava.restaurant.repository.VoteHistoryRepository;
import ru.topjava.restaurant.service.RestaurantMenuService;
import ru.topjava.restaurant.service.VoteService;

import java.util.List;

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
    private RestaurantMenuService restaurantMenuService;

    @Autowired
    private VoteHistoryRepository voteHistoryRepository;

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

    //отображение меню (список блюд) ресторана на сегодня у конкретного ресторана
    @GetMapping(value = "/restaurant/{id}/menuToday")
    public List<RestaurantMenu> menuTodayByRestaurantId(@PathVariable("id") long id) {
        return restaurantMenuService.getMenuTodayByRestaurant(id);
    }
}

