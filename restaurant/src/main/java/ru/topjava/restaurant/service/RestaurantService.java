package ru.topjava.restaurant.service;

import ru.topjava.restaurant.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    List<Restaurant> getAll();

    void create(Restaurant restaurant);

    void update(Restaurant restaurant, long restaurantId);

    void delete(long restaurantId);

    Restaurant getById(long id);
}
