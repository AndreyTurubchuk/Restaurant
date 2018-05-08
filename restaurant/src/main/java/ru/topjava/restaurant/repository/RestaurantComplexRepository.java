package ru.topjava.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.topjava.restaurant.model.RestaurantComplex;
import ru.topjava.restaurant.model.RestaurantMenu;

import java.util.List;

@Repository
public interface RestaurantComplexRepository extends JpaRepository<RestaurantComplex, Long> {
    List<RestaurantComplex> findRestaurantComplexByRestaurantRestaurantId(Long complexId);

}
