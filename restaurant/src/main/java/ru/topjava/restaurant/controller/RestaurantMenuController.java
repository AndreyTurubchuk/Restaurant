package ru.topjava.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.topjava.restaurant.model.Dish;
import ru.topjava.restaurant.model.Restaurant;
import ru.topjava.restaurant.model.RestaurantMenu;
import ru.topjava.restaurant.service.DishService;
import ru.topjava.restaurant.service.RestaurantMenuService;

import java.util.List;

@RestController
@RequestMapping(value = "restaurant/menu/api/v1")
public class RestaurantMenuController {

    @Autowired
    private DishService dishService;

    @Autowired
    private RestaurantMenuService restaurantMenuService;

    @GetMapping(value = "/restaurantmenu")
    public List<RestaurantMenu> restaurantMenuList() {
        return restaurantMenuService.getAll();
    } // лист

    @GetMapping(value = "/")
    public List<RestaurantMenu> restaurantMenus() {
        Dish dish = new Dish("картошка31", 3.0);
        dishService.create(dish);
        Dish dish2 = new Dish("картошка32", 32.0);
        dishService.create(dish2);
        Restaurant restaurant = new Restaurant(0L);
        restaurantMenuService.create(dish, restaurant);
        return restaurantMenuService.getAll();
    } // лист

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE) //создание
    public void create(@RequestBody Dish dish, Restaurant restaurant) {
        restaurantMenuService.create(dish, restaurant);
    }

}
