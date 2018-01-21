package ru.topjava.restaurant.service;

import com.sun.org.apache.regexp.internal.RE;
import ru.topjava.restaurant.model.Dish;
import ru.topjava.restaurant.model.Restaurant;
import ru.topjava.restaurant.model.RestaurantMenu;

import java.util.List;

public interface RestaurantMenuService {
    List<RestaurantMenu> getAll();

    //void create(RestaurantMenu restaurantMenu);

    void create(Dish dish, Restaurant restaurant);

    void update(RestaurantMenu restaurantMenu, long restaurantMenuId);

    void delete(long restaurantMenuId);

    RestaurantMenu getById(long id);

}
