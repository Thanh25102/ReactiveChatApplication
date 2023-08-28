package com.example.reactivedemo.repository;

import com.example.reactivedemo.domain.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepo extends ReactiveCrudRepository<User, UUID> {
}
