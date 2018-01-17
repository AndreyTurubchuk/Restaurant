package ru.topjava.restaurant.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "RESTAURANT_MENU")
public class RestaurantMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;

    public RestaurantMenu() {
    }

    public RestaurantMenu(Dish dish) {
        this.dish = dish;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }
}
