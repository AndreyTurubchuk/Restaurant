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

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }
}

