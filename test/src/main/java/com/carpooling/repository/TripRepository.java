package com.carpooling.repository;

import com.carpooling.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByOriginAndDestination(String origin, String destination);
}
