package com.example.reactivedemo.service;

import com.example.reactivedemo.domain.User;
import com.example.reactivedemo.repository.UserRepo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class UserService {
    private final UserRepo userRepo;
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    public Mono<User> save(User user) {
        return userRepo.save(user);
    }
    public Flux<User> findAll() {
        return userRepo.findAll();
    }

    public Mono<User> findById(UUID id) {
        return userRepo.findById(id);
    }
}
