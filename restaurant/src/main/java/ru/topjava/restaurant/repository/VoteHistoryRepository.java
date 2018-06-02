package ru.topjava.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.topjava.restaurant.model.VoteHistory;

public interface VoteHistoryRepository extends JpaRepository<VoteHistory, Long> {
}
