package ru.topjava.restaurant.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.topjava.restaurant.model.Restaurant;
import ru.topjava.restaurant.repository.RestaurantRepository;
import ru.topjava.restaurant.restaurantMenu.RestaurantMenu;
//import ru.topjava.restaurant.model.Restaurant;
//import ru.topjava.restaurant.service.RestaurantService;

import java.util.List;


@Controller
@RequestMapping(value = "restaurant")
//@RequestMapping(value = "restaurant/restaurant/api/v1")
public class RestaurantController {

    @Autowired
    RestaurantRepository restaurantRepository;

/*    @GetMapping(value = "/restaurants")
    public List<Restaurant>  restaurants() {
        return restaurantRepository.findAll();
    } // лист*/

    @GetMapping(value = "/restaurant/add") //создание
    public String restaurantAdd(Model model) {
        model.addAttribute("restaurant", new Restaurant());
        return "restaurantAddForm";
        //return "test";
    }

    @PostMapping("/restaurant/add")
    public String restaurantSubmit(@ModelAttribute Restaurant restaurant) {
        restaurantRepository.save(restaurant);
        //dishService.create(dish);
        return "redirect:/restaurant/restaurant/add"; // переход на форму ввода блюд

    }

}
//rest
/*
@RestController
@RequestMapping(value = "restaurant/restaurant/api/v1")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping(value = "/restaurants")
    public List<Restaurant> restaurants() {
        return restaurantService.getAll();
    } // лист

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE) //создание
    public void create(@RequestBody Restaurant restaurant) {
        restaurantService.create(restaurant);
    }

    @GetMapping("/{id}")
    public Restaurant get(@PathVariable("id") long id) {
        return restaurantService.getById(id);
    } // поиск по id
}
*/
