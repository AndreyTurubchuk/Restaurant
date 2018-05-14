package ru.topjava.restaurant.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RESTAURANT")
public class Restaurant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long restaurantId;

    private String name;

    private Long rating;
    //private String rating;

   // @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant", cascade = CascadeType.REMOVE, orphanRemoval = true)
   // private List<RestaurantComplex> restaurantComplexList;

/*    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<RestaurantMenu> restaurantMenuList;*/

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

    public void setRating(Long rating) {
        this.rating = rating;
    }

/*    public List<RestaurantMenu> getRestaurantMenuList() {
        return restaurantMenuList;
    }

    public void setRestaurantMenuList(List<RestaurantMenu> restaurantMenuList) {
        this.restaurantMenuList = restaurantMenuList;
    }*/

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }

/*    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }*/
}

