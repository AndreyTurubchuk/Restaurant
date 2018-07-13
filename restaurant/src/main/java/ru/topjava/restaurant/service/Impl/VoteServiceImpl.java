package ru.topjava.restaurant.service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import ru.topjava.restaurant.model.Restaurant;
import ru.topjava.restaurant.model.VoteHistory;
import ru.topjava.restaurant.repository.RestaurantRepository;
import ru.topjava.restaurant.repository.VoteHistoryRepository;
import ru.topjava.restaurant.service.VoteService;
import ru.topjava.restaurant.util.DateTimeUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Repository
public class VoteServiceImpl implements VoteService {

    protected final Logger log = LoggerFactory.getLogger(getClass());
    private LocalDateTime startTime = LocalDate.now().atTime(LocalTime.MIDNIGHT);
    private LocalDateTime endTime = LocalDate.now().atTime(LocalTime.MAX);
    private LocalTime endTimeDay = LocalTime.MAX;
    private LocalTime voteEndTime = LocalTime.of(23, 0, 0);
    private static final String VOTE_CLOSED = "Vote is closed. Vote is possible only 00-00 to 11-00";
    private static final String VOTE_SUCCESS = "vote for restaurant has taken successfully";

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private VoteHistoryRepository voteHistoryRepository;

    @Override
    public String voteForRestaurant(long restaurantId) {
        String resultVote;
        Restaurant restaurant = restaurantRepository.findRestaurantByRestaurantId(restaurantId);
        if (restaurant == null) {
            log.error("Vote is impossible. Restaurant with id {} not found. ", restaurantId);
            return "Vote is impossible. Restaurant not found";
        }
        if (DateTimeUtil.isBetween(LocalTime.now(), voteEndTime, endTimeDay)) {
            resultVote = VOTE_CLOSED;
        } else {
            SecurityContext context = SecurityContextHolder.getContext();
            String userName = context.getAuthentication().getName();

            // уменьшение голоса у последнего ресторана, за который голосовал пользователь сегодня
            // надо выяснить, голосовал ли пользователь в этот день !isVoteToday()
            VoteHistory voteHistoryLast = voteHistoryRepository.findFirstByUsernameOrderByIdDesc(userName); //последнее голосование
            if ((voteHistoryLast != null) & (!isVoteToday())) { // если голосовал сегодня и это последнее голосование, то уменьшаем.
                long currentRgLast = voteHistoryLast.getRestaurant().getRating() - 1;
                Restaurant restaurantLast = voteHistoryLast.getRestaurant();
                restaurantLast.setRating(currentRgLast);
                restaurantRepository.save(restaurantLast);
            }
            voteHistoryRepository.save(VoteHistory.builder()
                    .username(userName)
                    .restaurant(restaurant)
                    .dateTimeVote(LocalDateTime.now())
                    .build()
            );

            // увеличение голоса у текущего ресторана
            long currentRg = restaurant.getRating() + 1;
            restaurant.setRating(currentRg);
            restaurantRepository.save(restaurant);
            resultVote = VOTE_SUCCESS;
        }
        return resultVote;
    }

    @Override
    public boolean isVoteToday() {
        List<VoteHistory> voteHistories = voteHistoryRepository.findAll();
        return voteHistories.stream()
                .filter(voteHistory -> DateTimeUtil.isBetween(voteHistory.getDateTimeVote(), startTime, endTime))
                .collect(toList())
                .isEmpty();
    }
}
