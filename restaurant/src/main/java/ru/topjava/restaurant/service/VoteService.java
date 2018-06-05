package ru.topjava.restaurant.service;

import org.springframework.stereotype.Service;

@Service
public interface VoteService {

    String voteForRestaurant(long restaurantId);
    boolean isVoteToday(); // Whether there was a vote today

}

