package ru.topjava.restaurant.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RESTAURANT")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long restaurantId;

    private String name;

    private Long rating;

    @OneToMany(mappedBy = "restaurant")
    private List<RestaurantMenu> restaurantMenus = new ArrayList<>();

    public Restaurant(String name) {
        this.rating = 0L;
        this.name = name;
    }

    public Restaurant() {
        this.rating = 0L;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public List<RestaurantMenu> getRestaurantMenus() {
        return restaurantMenus;
    }

    public void setRestaurantMenus(List<RestaurantMenu> restaurantMenus) {
        this.restaurantMenus = restaurantMenus;
    }
}
