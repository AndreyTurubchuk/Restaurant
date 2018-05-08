package ru.topjava.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

@Controller
@RequestMapping(value = "restaurant/complex")
public class RestaurantMenuController {

    @Autowired
    DishRepository dishRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    RestaurantMenuRepository restaurantMenuRepository;

    @Autowired
    RestaurantComplexRepository restaurantComplexRepository;


/*    @GetMapping(value = "/")
    public String restaurantMenus(Model model) {
        model.addAttribute("restaurantMenuList", restaurantMenuRepository.findAll());
        return "complexMenu";
    }*/

    @GetMapping(value = "/{complexId}/menu") //отображение блюд одного комплекса
    public String dishAddByComplex(Model model, @PathVariable long complexId) {
        model.addAttribute("restaurantMenuList", restaurantMenuRepository.findRestaurantMenuByRestaurantComplexId(complexId));
        model.addAttribute("dishList", dishRepository.findAll());
        RestaurantMenu restaurantMenu = new RestaurantMenu();
        restaurantMenu.setRestaurantComplex(restaurantComplexRepository.getOne(complexId));
        model.addAttribute("restaurantMenu", restaurantMenu);
        return "complexMenu";
    }

    @PostMapping("/menu/dish/save") // запись блюда в меню комплекса
    public String dishAddByComplexSaveSubmit(@ModelAttribute RestaurantMenu restaurantMenu) {
        restaurantMenuRepository.save(restaurantMenu);
        long complexId = restaurantMenu.getRestaurantComplex().getId();
        return "redirect:/restaurant/complex/" + complexId + "/menu";
    }

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
