package ru.topjava.restaurant.controller.rest.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.topjava.restaurant.model.Dish;
import ru.topjava.restaurant.repository.DishRepository;
import java.util.List;

@RestController
@RequestMapping(value = "/admin/rest/api/v1")
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
        if (dishRepository.findById(id) == null) {
            log.error("Dish with id {} not found. ", id);
            return null;
        } else {
            return dishRepository.findById(id);
        }
    }

    // create a Dish
    @PostMapping("/dishes")
    public void create(@RequestBody Dish dish) {
        log.info("Creating Dish : {}", dish);
        dishRepository.save(dish);
    }

    // update a Dish
    @PutMapping("/dishes/{id}")
    public void update(@RequestBody Dish dish, @PathVariable("id") long id) {
        log.info("Updating Dish with id {}", id);
        if (dishRepository.findById(id) == null) {
            log.error("Unable to update. Dish with id {} not found. ", id);
        } else {
            dishRepository.save(dish);
        }
    }

    // delete a Dish
    @DeleteMapping(value = "/dishes/{id}")
    public void delete(@PathVariable("id") long id) {
        dishRepository.delete(id);
    }
}
