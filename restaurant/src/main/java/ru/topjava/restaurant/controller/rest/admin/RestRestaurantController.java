package ru.topjava.restaurant.controller.rest.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.topjava.restaurant.model.Restaurant;
import ru.topjava.restaurant.repository.RestaurantRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/admin/rest/api/v1")
public class RestRestaurantController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestaurantRepository restaurantRepository;

    //список всех ресторанов для администратора
    @GetMapping("/restaurants")
    public List<Restaurant> restaurants() {
        return restaurantRepository.findAll();
    }

    //выбор ресторана по id
    @GetMapping("/restaurants/{id}")
    public Restaurant get(@PathVariable("id") long id) {
        return restaurantRepository.findRestaurantByRestaurantId(id);
    }

    // create a Restaurant
    @PostMapping("/restaurants/")
    public void create(@RequestBody Restaurant restaurant) {
        log.info("Creating Restaurant : {}", restaurant);
        restaurantRepository.save(restaurant);
    }

    // update a Restaurant
    @PutMapping("/restaurants/{id}")
    public void update(@RequestBody Restaurant restaurant, @PathVariable("id") long id) {
        log.info("Updating Restaurant with id {}", id);
        if (restaurantRepository.findRestaurantByRestaurantId(id) == null) {
            log.error("Unable to update. Restaurant with id {} not found. ", id);
        } else {
            restaurantRepository.save(restaurant);
        }
    }

    // delete a Restaurant
    @DeleteMapping(value = "/restaurants/{id}")
    public void delete(@PathVariable("id") long id) {
        restaurantRepository.delete(id);
    }

}
