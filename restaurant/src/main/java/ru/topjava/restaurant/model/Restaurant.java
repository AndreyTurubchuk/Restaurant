package ru.topjava.restaurant.model;

import javax.persistence.*;

@Entity
@Table(name = "RESTAURANT")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long restaurantId;

    private Long rating;

    public Restaurant() {
    }

    public Restaurant(Long rating) {
        this.rating = rating;
    }

    public long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }
}
