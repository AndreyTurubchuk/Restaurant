package ru.topjava.restaurant.service;

import ru.topjava.restaurant.model.Dish;

import java.util.List;

public interface DishService {
    List<Dish> getAll();

    void create(Dish dish);

    void update(Dish dish, long dishId);

    void delete(long dishId);

    Dish getById(long id);

}
