package ru.topjava.restaurant.controller.rest.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.topjava.restaurant.model.Dish;
import ru.topjava.restaurant.model.Restaurant;
import ru.topjava.restaurant.model.RestaurantMenu;
import ru.topjava.restaurant.repository.DishRepository;
import ru.topjava.restaurant.repository.RestaurantMenuRepository;
import ru.topjava.restaurant.repository.RestaurantRepository;
import ru.topjava.restaurant.service.RestaurantMenuService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/admin/rest/api/v1")
public class RestRestaurantMenuController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestaurantMenuRepository restaurantMenuRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private RestaurantMenuService restaurantMenuService;

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
    @PostMapping("/menu")
    public void create(@RequestBody RestaurantMenu restaurantMenu) {
        log.info("creating RestaurantMenu : {}", restaurantMenu);
        restaurantMenuRepository.save(restaurantMenu);
    }

    // update a Menu
    @PutMapping("/menu/{id}")
    public void update(@RequestBody RestaurantMenu restaurantMenu, @PathVariable("id") long id) {
        log.info("Updating RestaurantMenu with id {}", id);
        if (restaurantMenuRepository.findRestaurantMenuByRestaurantMenuId(id) == null) {
            log.error("Unable to update. RestaurantMenu with id {} not found. ", id);
        } else {
            restaurantMenuRepository.save(restaurantMenu);
        }
    }


    // delete a Menu
    @DeleteMapping("/menu/{id}") // удаление
    public void delete(@PathVariable("id") long id) {
        restaurantMenuRepository.delete(id);
    }

    //отображение всех блюд ресторана с меню за все дни
    @GetMapping(value = "/restaurants/{id}/menu") //отображение блюд одного ресторана с одним меню
    public List<RestaurantMenu> menuByRestaurantId(@PathVariable("id") long id) {
        log.info("menu (list of dishes) by restaurant {}", id);
        return restaurantMenuRepository.findRestaurantMenuByRestaurantRestaurantId(id);
    }

    //отображение меню (список блюд) ресторана на сегодня у конкретного ресторана
    @GetMapping(value = "/restaurants/{id}/menuToday")
    public List<RestaurantMenu> menuTodayByRestaurantId(@PathVariable("id") long id) {
        log.info("menu (list of dishes) today by restaurant {}", id);
        return restaurantMenuService.getMenuTodayByRestaurant(id);
    }

    // добавление блюда в меню ресторана
    @GetMapping("/restaurants/{id}/dish/{dishId}/addDishByMenuByRestaurant")
    public String addDishByMenuByRestaurant(@PathVariable("id") long id,
                                               @PathVariable("dishId") long dishId) {
        log.info("add Dish {}", dishId + " by Menu by restaurant {}", id);
        RestaurantMenu rm = new RestaurantMenu();
        //rm.setCreatedDate(LocalDateTime.now());
        Restaurant restaurant = restaurantRepository.getOne(id);
        Dish dish = dishRepository.getOne(dishId);
        rm.setDish(dish);
        rm.setRestaurant(restaurant);
        restaurantMenuRepository.save(rm);
        return "add dish " + dish.getId() + " in menu of restaurant " + restaurant.getRestaurantId() + " successfully";

    }

}
