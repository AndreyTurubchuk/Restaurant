package ru.topjava.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.topjava.restaurant.model.Dish;

import ru.topjava.restaurant.model.Restaurant;
import ru.topjava.restaurant.model.RestaurantComplex;
import ru.topjava.restaurant.model.RestaurantMenu;
import ru.topjava.restaurant.repository.DishRepository;
import ru.topjava.restaurant.repository.RestaurantComplexRepository;
import ru.topjava.restaurant.repository.RestaurantMenuRepository;
import ru.topjava.restaurant.repository.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "restaurant/menu")
public class RestaurantMenuController {

    @Autowired
    DishRepository dishRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    RestaurantMenuRepository restaurantMenuRepository;

    @Autowired
    RestaurantComplexRepository restaurantComplexRepository;



    @GetMapping(value = "/")
    public RestaurantMenu restaurantMenus() {
        Dish dish = new Dish("картошка31", 3.0);
       // Dish dish2 = new Dish("картошка32", 32.0);
        dishRepository.save(dish);
       // dishRepository.save(dish2);

       // List<Dish> list = new ArrayList<>();
      //  list.add(dish);
      //  list.add(dish2);
        Restaurant r = new Restaurant("Paratov");
        restaurantRepository.save(r);
        RestaurantComplex rc = new RestaurantComplex(r);
        restaurantComplexRepository.save(rc);
        RestaurantMenu rm = new RestaurantMenu(dish, rc);
        restaurantMenuRepository.save(rm);
        //rm.setDish(dish);
      //  r.addDish(dish);
      //  r.addDish(dish2);

        return rm;

    } // лист


    @GetMapping(value = "/addComplex")
    public RestaurantComplex restaurantComplex(Restaurant restaurant) {
        RestaurantComplex rc = new RestaurantComplex(restaurant);
        restaurantComplexRepository.save(rc);
        return rc;
    }

}


/*

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.topjava.restaurant.model.Dish;
import ru.topjava.restaurant.model.Restaurant;
import ru.topjava.restaurant.restaurantMenu.RestaurantMenu;
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
        Restaurant restaurant = new Restaurant();
        restaurantMenuService.create(dish, restaurant);
        return restaurantMenuService.getAll();
    } // лист

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE) //создание
    public void create(@RequestBody Dish dish, Restaurant restaurant) {
        restaurantMenuService.create(dish, restaurant);
    }

}
*/
