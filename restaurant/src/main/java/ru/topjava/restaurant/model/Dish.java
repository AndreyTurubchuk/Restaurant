package ru.topjava.restaurant.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DISH")
public class Dish implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long dishId;

    private String name;
    private Double price;

    public Dish() {
    }

    public Dish(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public long getDishId() {
        return dishId;
    }

    public void setDishId(long dishId) {
        this.dishId = dishId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "dishId=" + dishId +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
