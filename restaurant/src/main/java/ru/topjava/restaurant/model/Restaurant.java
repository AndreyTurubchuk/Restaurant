package ru.topjava.restaurant.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RESTAURANT")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long restaurantId;

    private String name;

    private Long rating;

/*    public long getRestaurantId() {
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
    }*/

}


// @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant", cascade = CascadeType.REMOVE, orphanRemoval = true)
// private List<RestaurantComplex> restaurantComplexList;

/*    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<RestaurantMenu> restaurantMenuList;*/

