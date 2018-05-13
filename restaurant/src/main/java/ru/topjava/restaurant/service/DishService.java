package ru.topjava.restaurant.service;

import ru.topjava.restaurant.model.Dish;

import java.util.List;

public interface DishService {
    List<Dish> getAll();

    void create(Dish dish);

    void update2(Dish dish, long dishId);

    void update(Dish dish);

    void delete(long dishId);

    Dish getById(long id);

}
