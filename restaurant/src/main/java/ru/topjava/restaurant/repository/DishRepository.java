package ru.topjava.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.topjava.restaurant.model.Dish;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
    Dish findById(Long id);

/*    @Query("select d.id, d.name, d.createdDate, d.price from Dish d LEFT JOIN d.restaurantMenus AS rm WHERE rm.restaurant.restaurantId = :id") // поиск блюд по номеру ресторана
    List<Dish> getDishesForRestaurant(
            @Param("id") Long id);*/

/*    @Query("from Dish d LEFT JOIN d.restaurantMenus AS rm WHERE rm.restaurant.restaurantId = :id") // поиск блюд по номеру ресторана
    List<Dish> getDishesForRestaurant(
            @Param("id") Long id);*/

  //  @Query("select d from Dish d LEFT JOIN d.restaurantMenus AS rm")
        // поиск блюд по номеру ресторана
   // List<Dish> getDishesForRestaurant();


}
   /* @Query("SELECT v from Voting v WHERE v.user.id=:userId AND v.operDate BETWEEN :startDate AND :endDate ORDER BY v.operDate DESC")
    List<Voting> getBetweenDateByUser(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate, @Param("userId") int userId);*/

/*    @Query("select d from Dish d LEFT JOIN d.restaurantMenus AS rm WHERE rm.restaurant.restaurantId = :id AND d.createdDate BETWEEN :startDate AND :endDate")
        // поиск блюд по номеру ресторана
    List<Dish> getDishesForRestaurant(
            @Param("id") Long id,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate);*/
