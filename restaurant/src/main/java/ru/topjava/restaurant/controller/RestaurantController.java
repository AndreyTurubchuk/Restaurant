package ru.topjava.restaurant.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.topjava.restaurant.model.Restaurant;
import ru.topjava.restaurant.service.RestaurantService;

import java.util.List;

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
