package ru.topjava.restaurant.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.topjava.restaurant.model.Dish;
import ru.topjava.restaurant.model.Restaurant;
import ru.topjava.restaurant.model.RestaurantMenu;
import ru.topjava.restaurant.repository.DishRepository;
import ru.topjava.restaurant.repository.RestaurantMenuRepository;
import ru.topjava.restaurant.repository.RestaurantRepository;
import ru.topjava.restaurant.service.DishService;
import ru.topjava.restaurant.service.RestaurantMenuService;

import java.util.List;

@Service
public class RestaurantMenuServiceImpl implements RestaurantMenuService {

    @Autowired
    private RestaurantMenuRepository restaurantMenuRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private DishRepository dishRepository;

    @Override
    public List<RestaurantMenu> getAll() {
        return restaurantMenuRepository.findAll();
    }


    @Override
    public void create(Dish dish, Restaurant restaurant) {
        dishRepository.save(dish);
        restaurantRepository.save(restaurant);
        RestaurantMenu restaurantMenu = new RestaurantMenu(dish, restaurant);
        restaurantMenuRepository.save(restaurantMenu);
    }

    @Override
    public void update(RestaurantMenu restaurantMenuDetails, long restaurantMenuId) {
        RestaurantMenu restaurantMenu = restaurantMenuRepository.getOne(restaurantMenuId);
        restaurantMenu.setDish(restaurantMenuDetails.getDish());
        restaurantMenuRepository.save(restaurantMenu);
    }

/*    @Override
    public void update(Dish dishDetails, long dishId) {
        Dish dish = dishRepository.getOne(dishId);
        dish.setName(dishDetails.getName());
        dish.setPrice(dishDetails.getPrice());
        dishRepository.save(dish);
    }*/

    @Override
    public void delete(long restaurantMenuId) {
        restaurantMenuRepository.delete(restaurantMenuId);
    }

    @Override
    public RestaurantMenu getById(long id) {
        return restaurantMenuRepository.findRestaurantMenuById(id);
    }
}
