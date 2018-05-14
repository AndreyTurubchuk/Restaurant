package ru.topjava.restaurant.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RESTAURANT_MENU")
public class RestaurantMenu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long restaurantMenuId;

    //@ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "DISH_ID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Dish dish;

    //@ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Restaurant restaurant;

    public RestaurantMenu() {
    }

    public RestaurantMenu(Dish dish, Restaurant restaurant) {
        this.dish = dish;
     //   this.restaurant = restaurant;
    }

    public long getRestaurantMenuId() {
        return restaurantMenuId;
    }

    public void setRestaurantMenuId(long restaurantMenuId) {
        this.restaurantMenuId = restaurantMenuId;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }


}
