package ru.topjava.restaurant.model;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "RESTAURANT_MENU")
@Getter
@Setter
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class RestaurantMenu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long restaurantMenuId;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "DISH_ID")
    //@OnDelete(action = OnDeleteAction.CASCADE)
    private Dish dish;

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Restaurant restaurant;
}
