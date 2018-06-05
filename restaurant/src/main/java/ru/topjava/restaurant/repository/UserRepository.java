package ru.topjava.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.topjava.restaurant.model.User;

import javax.validation.constraints.NotNull;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(@NotNull String username);
}
