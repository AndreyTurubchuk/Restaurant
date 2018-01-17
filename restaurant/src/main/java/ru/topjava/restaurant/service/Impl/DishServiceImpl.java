package ru.topjava.restaurant.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.topjava.restaurant.model.Dish;
import ru.topjava.restaurant.repository.DishRepository;
import ru.topjava.restaurant.service.DishService;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishRepository dishRepository;

    @Override
    public List<Dish> getAll() {
        return dishRepository.findAll();
    }

    @Override
    public void saveDish(Dish dish) {
        dishRepository.save(dish);
    }
}
