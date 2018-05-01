package ru.topjava.restaurant.model;

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

    @ManyToOne
    @JoinColumn(name = "DISH_ID")
    private Dish dish;

    @ManyToOne
    @JoinColumn(name = "COMPLEX_ID")
    private RestaurantComplex restaurantComplex;

    //private List<Dish> dishList; // в 1 меню несколько блюд

    public RestaurantMenu() {
   //     this.dishList = new ArrayList<>();
    }

    public RestaurantMenu(Dish dish, RestaurantComplex restaurantComplex) {
        this.dish = dish;
        this.restaurantComplex = restaurantComplex;
    }

    public long getRestaurantMenuId() {
        return restaurantMenuId;
    }

    public void setRestaurantMenuId(long restaurantMenuId) {
        this.restaurantMenuId = restaurantMenuId;
    }

    public RestaurantComplex getRestaurantComplex() {
        return restaurantComplex;
    }

    public void setRestaurantComplex(RestaurantComplex restaurantComplex) {
        this.restaurantComplex = restaurantComplex;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public RestaurantMenu(Dish dish) {
        this.dish = dish;
    }

    @Override
    public String toString() {
        return "RestaurantMenu{" +
                "restaurantMenuId=" + restaurantMenuId +
                ", dish=" + dish +
                '}';
    }
/*    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }*/

    /*    public RestaurantMenu(List<Dish> dishList) {
        this.dishList = dishList;
    }*/



/*    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }*/

/*    public void addDish(Dish dish) {
        dishList.add(dish);
    }*/

/*    public void show() {
        for (Dish dish : dishList
                ) {
            System.out.println(dish.toString());
        }
    }*/
}
