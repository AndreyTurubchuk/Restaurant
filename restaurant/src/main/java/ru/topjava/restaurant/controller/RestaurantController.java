package ru.topjava.restaurant.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.topjava.restaurant.model.Dish;
import ru.topjava.restaurant.model.Restaurant;
import ru.topjava.restaurant.repository.RestaurantRepository;
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

    @GetMapping(value = "/restaurants")
    public String restaurantList(Model model) {
        model.addAttribute("restaurantList", restaurantRepository.findAll());
        return "restaurantAll";
    }

    @GetMapping(value = "/restaurantList")
    public List<Restaurant> restaurants() {
        return restaurantRepository.findAll();
    } // лист

    @GetMapping(value = "/restaurant/create") //создание
    public String restaurantCreate(Model model) {
        model.addAttribute("restaurant", new Restaurant());
        return "restaurantForm";
    }

    @GetMapping(value = "/restaurant/{id}") //редактирование
    public String restaurantEdit(Model model, @PathVariable long id) {
        model.addAttribute("restaurant", restaurantRepository.getOne(id));
        return "restaurantForm";
    }

    @PostMapping("restaurant/save") //post для create, update
    public String restaurantSaveSubmit(@ModelAttribute Restaurant restaurant) {
        restaurantRepository.save(restaurant);
        return "redirect:/restaurant/restaurants";
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
