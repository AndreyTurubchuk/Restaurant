package ru.topjava.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import ru.topjava.restaurant.model.Dish;

import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
    //List<Dish> findByToOrderByTo(String to);
    Dish findByDishId(Long id);
}
