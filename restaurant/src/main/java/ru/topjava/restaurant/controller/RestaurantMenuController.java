package ru.topjava.restaurant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ru.topjava.restaurant.model.Restaurant;
import ru.topjava.restaurant.model.RestaurantMenu;
import ru.topjava.restaurant.repository.DishRepository;
import ru.topjava.restaurant.repository.RestaurantMenuRepository;
import ru.topjava.restaurant.repository.RestaurantRepository;

import java.util.List;

@Controller
@RequestMapping(value = "restaurant")
public class RestaurantMenuController {

    @Autowired
    DishRepository dishRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    RestaurantMenuRepository restaurantMenuRepository;

/*    @GetMapping(value = "/{restaurantId}/menu") //отображение блюд одного ресторана с одним меню
    public String menuByRestaurantId(Model model, @PathVariable("restaurantId") long id) {
        model.addAttribute("restaurantMenuList", restaurantMenuRepository.findRestaurantMenuByRestaurantRestaurantId(id));
        model.addAttribute("dishList", dishRepository.findAll());
        model.addAttribute("restaurantId2", id);

        //  model.addAttribute("restaurantMenu", id);
        //return "restaurantMenuAll";
        return "mytest";
    }*/


    @PostMapping("/menu/dish/save") // запись блюда в меню комплекса
    public String dishAddByComplexSaveSubmit(@ModelAttribute RestaurantMenu restaurantMenu) {
/*        restaurantMenuRepository.save(restaurantMenu);
        long complexId = restaurantMenu.getRestaurantComplex().getId();
        return "redirect:/restaurant/complex/" + complexId + "/menu";*/
        return null;
    }

   /*    @GetMapping(value = "/")
    public String restaurantMenus(Model model) {
        model.addAttribute("restaurantMenuList", restaurantMenuRepository.findAll());
        return "complexMenu";
    }*/
/*
    @GetMapping(value = "/{restaurantId}/menu") //отображение блюд одного ресторана с одним меню
    public List<RestaurantMenu> menuForm(Model model, @PathVariable long restaurantId) {
        //model.addAttribute("restaurantMenuList", restaurantMenuRepository.findRestaurantMenuByRestaurantRestaurantId(restaurantId));
        //model.addAttribute("dishList", dishRepository.findAll());
        //RestaurantMenu restaurantMenu = new RestaurantMenu();
       // restaurantMenu.setRestaurantComplex(restaurantComplexRepository.getOne(complexId));
        //model.addAttribute("restaurantMenu", restaurantMenu);
        //return "restaurantMenu";
        List<RestaurantMenu> restaurantMenu = restaurantMenuRepository.findRestaurantMenuByRestaurantRestaurantId(restaurantId);
        return restaurantMenuRepository.findRestaurantMenuByRestaurantRestaurantId(restaurantId);

    }*/

/*    @PostMapping("/menu/dish/save") // запись блюда в меню комплекса
    public String dishAddByComplexSaveSubmit(@ModelAttribute RestaurantMenu restaurantMenu) {
        restaurantMenuRepository.save(restaurantMenu);
        long complexId = restaurantMenu.getRestaurantComplex().getId();
        return "redirect:/restaurant/complex/" + complexId + "/menu";
    }

    @GetMapping(value = "/menu/delete/{restaurantMenuId}") // удаление блюда из меню комплекса
    public String delete(@PathVariable("restaurantMenuId") long restaurantMenuId) {
        restaurantMenuRepository.delete(restaurantMenuId);
        return "redirect:/restaurant/restaurants";
    }
    //menu/dish/delete/{dishId

    @GetMapping(value = "/addComplex")
    public RestaurantComplex restaurantComplex(Restaurant restaurant) {
        RestaurantComplex rc = new RestaurantComplex(restaurant);
        restaurantComplexRepository.save(rc);
        return rc;
    }*/

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

/*    @GetMapping(value = "/complex/{id}") //редактирование
    public String complexEdit(Model model, @PathVariable long id) {
        model.addAttribute("complex", restaurantComplexRepository.getOne(id));
        return "complexForm";
    }*/

   /* @GetMapping(value = "/complex/delete/{id}") // удаление
    public String delete(@PathVariable("id") long id) {
        restaurantComplexRepository.delete(id);
        return "redirect:/restaurant/restaurants";
    }

    @GetMapping(value = "/{restaurantId}/complex") // получение списка комплексов у ресторана по id ресторана
    public String complexAll(Model model, @PathVariable long restaurantId) {
        model.addAttribute("complexList", restaurantComplexRepository.findRestaurantComplexByRestaurantRestaurantId(restaurantId));
        model.addAttribute("restaurantId" , restaurantId);
        return "complexAll";
    }


    @GetMapping(value = "/{restaurantId}/complex/create") // создание комплекса у ресторана
    public String complexCreate(Model model, @PathVariable long restaurantId) {
        RestaurantComplex restaurantComplex = new RestaurantComplex();
        Restaurant restaurant = restaurantRepository.getOne(restaurantId);
        restaurantComplex.setRestaurant(restaurant);
        restaurantComplexRepository.save(restaurantComplex);
        model.addAttribute("complexList", restaurantComplexRepository.findRestaurantComplexByRestaurantRestaurantId(restaurantId));
        return "complexAll";
    }*/
