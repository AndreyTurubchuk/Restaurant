package ru.topjava.restaurant.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.topjava.restaurant.model.Dish;
import ru.topjava.restaurant.repository.DishRepository;
import ru.topjava.restaurant.service.DishService;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {
    @Override
    public List<Dish> getAll() {
        return null;
    }

    @Override
    public void create(Dish dish) {

    }

    @Override
    public void update(Dish dish) {

    }

    @Override
    public void delete(long dishId) {

    }

    @Override
    public Dish getById(long id) {
        return null;
    }

/*    @Autowired
    private DishRepository dishRepository;

    @Override
    public List<Dish> getAll() {
        return dishRepository.findAll();
    }

    @Override
    public void create(Dish dish) {
        dishRepository.save(dish);
    }

    @Override
    public void update(Dish dish) {
        dishRepository.save(dish);
    }

*//*    @Override
    public void update(Dish dishDetails, long dishId) {
        Dish dish = dishRepository.getOne(dishId);
        dish.setName(dishDetails.getName());
        dish.setPrice(dishDetails.getPrice());
        dishRepository.save(dish);
    }*//*

    @Override
    public void delete(long dishId) {
        dishRepository.delete(dishId);
    }

    @Override
    public Dish getById(long id) {
        return dishRepository.findById(id);
    }*/

}


