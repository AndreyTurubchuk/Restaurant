package ru.topjava.restaurant.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.topjava.restaurant.model.Dish;
import ru.topjava.restaurant.model.Restaurant;
import ru.topjava.restaurant.model.RestaurantMenu;
import ru.topjava.restaurant.repository.RestaurantRepository;
import ru.topjava.restaurant.service.RestaurantMenuService;
import ru.topjava.restaurant.service.RestaurantService;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;


    @Override
    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public void create(Restaurant restaurant) {

    }

    @Override
    public void update(Restaurant restaurant, long restaurantId) {

    }

    @Override
    public void delete(long restaurantId) {
        restaurantRepository.delete(restaurantId);
    }

    @Override
    public Restaurant getById(long id) {
        return restaurantRepository.findRestaurantByRestaurantId(id);
    }
}
