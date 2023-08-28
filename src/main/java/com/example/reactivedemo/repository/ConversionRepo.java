package com.example.reactivedemo.repository;

import com.example.reactivedemo.domain.Conversion;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConversionRepo extends ReactiveCrudRepository<Conversion, UUID> {
}
