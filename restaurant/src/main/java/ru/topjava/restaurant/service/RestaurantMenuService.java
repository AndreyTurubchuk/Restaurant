package ru.topjava.restaurant.service;

import org.springframework.stereotype.Service;
import ru.topjava.restaurant.model.RestaurantMenu;

import java.util.List;

@Service
public interface RestaurantMenuService {
    List<RestaurantMenu> getMenuTodayByRestaurant (Long id); // menu (list of dishes) today by Restaurant

}
