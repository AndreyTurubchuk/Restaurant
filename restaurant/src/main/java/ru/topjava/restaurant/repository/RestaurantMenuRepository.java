package ru.topjava.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.topjava.restaurant.model.RestaurantMenu;
import java.util.List;

@Repository
public interface RestaurantMenuRepository extends JpaRepository<RestaurantMenu, Long> {
    List<RestaurantMenu> findRestaurantMenuByRestaurantRestaurantId(Long restaurantMenuId);

    RestaurantMenu findRestaurantMenuByRestaurantMenuId(Long menuId);

}
