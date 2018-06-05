package ru.topjava.restaurant.service;

import org.springframework.stereotype.Service;
import ru.topjava.restaurant.model.Dish;

import java.util.List;

@Service
public interface DishService {
    List<Dish> getDishesToday(); // list of dishes for today

    List<Dish> getDishesTodayForRestaurant (Long id); // list of dishes for today for Restaurant

}
