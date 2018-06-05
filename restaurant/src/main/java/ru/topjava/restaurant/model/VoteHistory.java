package ru.topjava.restaurant.model;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Entity
@Table(name = "VOTE_HISTORY")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class VoteHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "USER_NAME")
    private String username;

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Restaurant restaurant;

    @Column(name = "DATE_TIME_OF_VOTING")
    private LocalDateTime dateTimeVote;
}
