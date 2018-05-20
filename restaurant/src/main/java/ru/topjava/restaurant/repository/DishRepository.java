package ru.topjava.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.topjava.restaurant.model.Dish;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {
    Dish findById(Long id);

    @SuppressWarnings("JpaQlInspection")
    @Query("SELECT d from Dish d  WHERE d.createdDate BETWEEN :startDate AND :endDate ORDER BY d.createdDate DESC")
    List<Dish> getBetween(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
