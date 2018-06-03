package ru.topjava.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.topjava.restaurant.model.VoteHistory;

import java.util.List;

public interface VoteHistoryRepository extends JpaRepository<VoteHistory, Long> {
    List<VoteHistory> findVoteHistoriesByUsername(String username);
    VoteHistory findFirstByUsernameOrderByIdDesc(String username);
}
