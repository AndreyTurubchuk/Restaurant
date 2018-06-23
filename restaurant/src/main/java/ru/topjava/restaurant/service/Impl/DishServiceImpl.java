package ru.topjava.restaurant.service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.topjava.restaurant.model.Dish;
import ru.topjava.restaurant.model.Restaurant;
import ru.topjava.restaurant.model.RestaurantMenu;
import ru.topjava.restaurant.repository.DishRepository;
import ru.topjava.restaurant.repository.RestaurantMenuRepository;
import ru.topjava.restaurant.repository.RestaurantRepository;
import ru.topjava.restaurant.service.DishService;
import ru.topjava.restaurant.util.DateTimeUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Repository
public class DishServiceImpl implements DishService {

    protected final Logger log = LoggerFactory.getLogger(getClass());
    private LocalDateTime startTime = LocalDate.now().atTime(LocalTime.MIDNIGHT);
    private LocalDateTime endTime = LocalDate.now().atTime(LocalTime.MAX);

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantMenuRepository restaurantMenuRepository;

    @Override
    public List<Dish> getDishesToday() {
        /*List<Dish> dishes = dishRepository.findAll();
        return dishes.stream()
                .filter(dish -> DateTimeUtil.isBetween(dish.getCreatedDate(), startTime, endTime))
                .collect(toList());*/
        return null;
    }

    @Override
    public List<RestaurantMenu> getDishesTodayForRestaurant(Long id) {
        Restaurant restaurant = restaurantRepository.findRestaurantByRestaurantId(id);
        if (restaurant == null) {
            log.error("Restaurant with id {} not found. ", id);
            return null;
        } else {
            List<RestaurantMenu> restaurantMenuList = restaurantMenuRepository.findRestaurantMenuByRestaurantRestaurantId(id);
            return restaurantMenuList.stream()
                    .filter(restaurantMenu -> DateTimeUtil.isBetween(restaurantMenu.getCreatedDate(), startTime, endTime))
                    .collect(toList());
        }
    }
}
