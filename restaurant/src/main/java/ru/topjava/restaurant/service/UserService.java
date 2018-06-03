package ru.topjava.restaurant.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.topjava.restaurant.model.Role;
import ru.topjava.restaurant.model.User;
import ru.topjava.restaurant.repository.UserRepository;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

/*    @PostConstruct
    public void init() {
        if (!(userRepository.findByUsername("username") == null)) {
            userRepository.save(User.builder()
                    .username("username12")
                    .password("password12")
                    .authorities(Collections.singletonList(Role.USER))
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .enabled(true)
                    .build()
            );
        }
    }*/

/*    public UserDetails loadUserByUsername(@NotNull String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }*/

    public UserDetails loadUserByUsername(@NotNull String username) throws UsernameNotFoundException {
        //return userRepository.findByUsername(username);
        return User.builder()
                .username("username12")
                .password("password12")
                .authorities(Collections.singletonList(Role.USER))
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true)
                .build();
    }

}
