package ru.topjava.restaurant.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "RESTAURANT_LINK_MENU")
public class RestaurantComplex {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID")
    private Restaurant restaurant;



    public RestaurantComplex() {
    }



    public RestaurantComplex(Restaurant restaurant) {
        this.restaurant = restaurant;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }


}
/*public class RestaurantComplex {
    //private Map<Restaurant, RestaurantMenu> restaurantComplex; // у одного ресторана несколько комплексов
    private Map<String, RestaurantMenu> restaurantComplex = new HashMap<>(); // у одного ресторана несколько комплексов

    *//*public RestaurantComplex() {
        RestaurantMenu restaurantMenu = new RestaurantMenu();
    }*//*

    public RestaurantComplex() {
        //restaurantComplex = new
    }

    public RestaurantComplex(Map<String, RestaurantMenu> restaurantComplex) {
        this.restaurantComplex = restaurantComplex;
    }

    public Map<String, RestaurantMenu> getRestaurantComplex() {
        return restaurantComplex;
    }

    public void setRestaurantComplex(Map<String, RestaurantMenu> restaurantComplex) {
        this.restaurantComplex = restaurantComplex;
    }

    public void addComplex(String s, RestaurantMenu restaurantMenu) {
        restaurantComplex.put(s, restaurantMenu);
    }

    @Override
    public String toString() {
        return "RestaurantComplex{" +
                "restaurantComplex=" + restaurantComplex +
                '}';
    }

    public void showKey() {
        for (String key : restaurantComplex.keySet()) {
            System.out.println("Key: " + key);
        }
    }

    public void showValue() {
        for (RestaurantMenu restaurantMenu : restaurantComplex.values()) {
            restaurantMenu.show();
        }
    }

    public void showAll() {
        for (Map.Entry entry : restaurantComplex.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: "
                    + entry.getValue());
        }
    }


}*/


