package ru.topjava.restaurant.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RESTAURANT")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long restaurantId;

    private String name;

    private Long rating;
    //private String rating;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<RestaurantComplex> restaurantComplexList;

    public Restaurant(String name) {
        this.rating = 0L;

        this.name = name;
    }

    /*public Restaurant() {
        this.rating = 0L;
    }*/

    public Restaurant() {
        this.rating = 0L;
    }

    public long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(long restaurantId) {
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

    public void setRating(long rating) {
        this.rating = rating;
    }

    public List<RestaurantComplex> getRestaurantComplexList() {
        return restaurantComplexList;
    }

    public void setRestaurantComplexList(List<RestaurantComplex> restaurantComplexList) {
        this.restaurantComplexList = restaurantComplexList;
    }

    /*    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }*/
}

