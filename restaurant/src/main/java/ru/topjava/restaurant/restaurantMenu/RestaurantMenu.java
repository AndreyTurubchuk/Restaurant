package ru.topjava.restaurant.restaurantMenu;

import ru.topjava.restaurant.model.Dish;

import java.util.ArrayList;
import java.util.List;

public class RestaurantMenu {
    private List<Dish> dishList;


    public RestaurantMenu() {
        this.dishList = new ArrayList<>();
    }

    public RestaurantMenu(List<Dish> dishList) {
        this.dishList = dishList;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }
}
