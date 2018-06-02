package ru.topjava.restaurant.controller.rest.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.topjava.restaurant.model.RestaurantMenu;
import ru.topjava.restaurant.repository.RestaurantMenuRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/admin/rest/api/v1")
public class RestRestaurantMenuController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestaurantMenuRepository restaurantMenuRepository;

    //список всех ресторанов с меню
    @GetMapping(value = "/menu")
    public List<RestaurantMenu> menuForm() {
        return restaurantMenuRepository.findAll();
    }

    //выбор ресторана по id
    @GetMapping("/menu/{id}")
    public RestaurantMenu get(@PathVariable("id") long id) {
        return restaurantMenuRepository.findRestaurantMenuByRestaurantMenuId(id);
    }

    // create a Menu
    @PostMapping("/menu/")
    public void create(@RequestBody RestaurantMenu restaurantMenu) {
        log.info("Creating RestaurantMenu : {}", restaurantMenu);
        restaurantMenuRepository.save(restaurantMenu);
    }

    // delete a Menu
    @DeleteMapping("/menu/{id}") // удаление
    public void delete(@PathVariable("id") long id) {
        restaurantMenuRepository.delete(id);
    }

    //отображение блюд одного ресторана с одним меню
    @GetMapping(value = "/restaurant/{restaurantId}/menu") //отображение блюд одного ресторана с одним меню
    public List<RestaurantMenu> menuByRestaurantId(@PathVariable("restaurantId") long id) {
        return restaurantMenuRepository.findRestaurantMenuByRestaurantRestaurantId(id);
    }
}
