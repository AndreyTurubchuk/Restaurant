package ru.topjava.restaurant.controller.rest.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.topjava.restaurant.model.Dish;
import ru.topjava.restaurant.model.Restaurant;
import ru.topjava.restaurant.repository.DishRepository;
import ru.topjava.restaurant.repository.RestaurantRepository;
import ru.topjava.restaurant.util.DateTimeUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping(value = "/restaurant/rest/user/api/v1")
public class VoiceController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private DishRepository dishRepository;

    //голосование зв ресторан по id
    @GetMapping("/restaurants/{id}/increase")
    public String get(@PathVariable("id") long id) {
        log.info("Voice user with restaurant {}", id);
        Restaurant currentRestaurant = restaurantRepository.findRestaurantByRestaurantId(id);
        if (currentRestaurant == null) {
            log.error("Unable to voice. Restaurant with id {} not found. ", id);
            return "Error";
        } else {
            long currentRaiting = currentRestaurant.getRating();
            currentRaiting = currentRaiting + 1;
            currentRestaurant.setRating(currentRaiting);
            restaurantRepository.save(currentRestaurant);
            return "ОК";
        }
    }

    //список блюд на сегодня для пользователя
    @GetMapping("/dishesToday")
    public List<Dish> dishes() {
        LocalDateTime startTime = LocalDate.now().atTime(LocalTime.MIDNIGHT);
        LocalDateTime endTime = LocalDate.now().atTime(LocalTime.MAX);
        Dish dish = new Dish();
        dish.setCreatedDate(LocalDateTime.now());
        dish.setName("milk");
        dish.setPrice(200.0);
        dishRepository.save(dish);
        List<Dish> dd = dishRepository.getBetween(startTime, endTime);
        List<Dish> dd4 = dishRepository.findAll();
/*        List<Dish> dd3 = dd4.stream()
                .filter(meal -> DateTimeUtil.isBetween(dish.getCreatedDate(), startTime, endTime))
                .collect(toList());*/
        List<Dish> dailyDishes = new ArrayList<>();
        for (Dish dish2 : dd4
                ) {
            if (DateTimeUtil.isBetween(dish2.getCreatedDate(), startTime, endTime)) {
                dailyDishes.add(dish2);
            }

        }
        return dailyDishes;
    }
}
