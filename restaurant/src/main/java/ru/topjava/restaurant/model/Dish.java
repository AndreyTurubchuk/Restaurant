package ru.topjava.restaurant.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "DISH")
@Getter
@Setter
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class Dish implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private Double price;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;


    //@OneToMany(mappedBy="dish")
    //private Set<RestaurantMenu> restaurantMenus = new HashSet<>();



}
