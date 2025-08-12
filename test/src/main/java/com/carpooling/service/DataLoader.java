package com.carpooling.service;

import com.carpooling.model.Trip;
import com.carpooling.model.User;
import com.carpooling.repository.TripRepository;
import com.carpooling.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {
    private final UserRepository userRepository;
    private final TripRepository tripRepository;

    public DataLoader(UserRepository userRepository, TripRepository tripRepository) {
        this.userRepository = userRepository;
        this.tripRepository = tripRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User driver = User.builder().name("John Driver").email("john@example.com").role("DRIVER").build();
        User passenger = User.builder().name("Alice Passenger").email("alice@example.com").role("PASSENGER").build();

        userRepository.save(driver);
        userRepository.save(passenger);

        Trip trip = Trip.builder()
                .origin("Hyderabad")
                .destination("Bangalore")
                .departureTime(LocalDateTime.now().plusDays(1))
                .price(500.0)
                .driver(driver)
                .build();

        tripRepository.save(trip);
    }
}

