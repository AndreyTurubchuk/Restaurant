package ru.topjava.restaurant.controller.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.topjava.restaurant.model.Dish;

import ru.topjava.restaurant.model.Restaurant;
import ru.topjava.restaurant.model.RestaurantMenu;
import ru.topjava.restaurant.repository.DishRepository;
import ru.topjava.restaurant.repository.RestaurantMenuRepository;
import ru.topjava.restaurant.repository.RestaurantRepository;
import ru.topjava.restaurant.service.DishService;

import java.util.List;

@RestController
//@RequestMapping(value = "restaurant/dish/api/v1")
@RequestMapping(value = "/restaurant/rest/admin/api/v1")
public class RestDishController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private DishRepository dishRepository;

    //список всех блюд для администратора
    @GetMapping("/dishes")
    public List<Dish> dishes() {
        return dishRepository.findAll();
    }

    //выбор блюда по id
    @GetMapping("/dishes/{id}")
    public Dish get(@PathVariable("id") long id) {
        return dishRepository.findByDishId(id);
    }

    // create a Dish
    @PostMapping("/dishes/")
    public void create(@RequestBody Dish dish) {
        log.info("Creating Dish : {}", dish);
        dishRepository.save(dish);
    }

    // update a Dish
    @PutMapping("/dishes/{id}")
    public void update(@RequestBody Dish dish, @PathVariable("id") long id) {
        log.info("Updating Dish with id {}", id);
        Dish currentDish = dishRepository.findByDishId(id);
        if (currentDish == null) {
            log.error("Unable to update. Dish with id {} not found. ", id);
        } else {
            currentDish.setName(dish.getName());
            currentDish.setPrice(dish.getPrice());
            dishRepository.save(currentDish);
        }
    }

    // delete a Dish
    @DeleteMapping(value = "/dishes/{id}")
    public void delete(@PathVariable("id") long id) {
        dishRepository.delete(id);
    }






}
