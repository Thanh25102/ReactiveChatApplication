package com.example.reactivedemo.bootstrap;

import com.example.reactivedemo.domain.User;
import com.example.reactivedemo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

@Component
public class InitUser implements CommandLineRunner {
    private final UserService userService;

    public InitUser(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) {
        var usersFlux = userService.findAll();
        User user = new User(UUID.randomUUID(), "manhthanh", "manhthanh147", "Thanh25102", true);
        usersFlux.collectList()
                .flatMap(users -> users.isEmpty() ? userService.save(user) : Mono.empty())
                .subscribe();
    }
}
