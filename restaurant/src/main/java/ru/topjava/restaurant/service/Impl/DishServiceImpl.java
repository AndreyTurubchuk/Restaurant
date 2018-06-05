package ru.topjava.restaurant.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.topjava.restaurant.model.Dish;
import ru.topjava.restaurant.repository.DishRepository;
import ru.topjava.restaurant.service.DishService;
import ru.topjava.restaurant.util.DateTimeUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Repository
public class DishServiceImpl implements DishService {

    private LocalDateTime startTime = LocalDate.now().atTime(LocalTime.MIDNIGHT);
    private LocalDateTime endTime = LocalDate.now().atTime(LocalTime.MAX);

    @Autowired
    private DishRepository dishRepository;

    @Override
    public List<Dish> getDishesToday() {
        List<Dish> dishes = dishRepository.findAll();
        return dishes.stream()
                .filter(dish -> DateTimeUtil.isBetween(dish.getCreatedDate(), startTime, endTime))
                .collect(toList());
    }

    @Override
    public List<Dish> getDishesForRestaurantToday(long id) {
        List<Dish> dishes = dishRepository.findAll();
        return dishes.stream()
                .filter(dish -> DateTimeUtil.isBetween(dish.getCreatedDate(), startTime, endTime))
                .collect(toList());
    }
}
