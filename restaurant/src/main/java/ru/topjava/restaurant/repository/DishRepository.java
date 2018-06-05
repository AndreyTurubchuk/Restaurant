package ru.topjava.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.topjava.restaurant.model.Dish;

import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
    Dish findById(Long id);

/*    @Query("SELECT d.id, d.createdDate, d.name, d.price FROM Dish d LEFT JOIN d.restaurantMenus AS rm WHERE rm.restaurant.restaurantId = :id")
    List<Dish> getDishesForRestaurant(
            @Param("id") Long id);*/

}
