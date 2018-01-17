package ru.topjava.restaurant.service;

import ru.topjava.restaurant.model.Dish;

import java.util.List;

public interface DishService {
    List<Dish> getAll();
    void saveDish(Dish dish);
}
