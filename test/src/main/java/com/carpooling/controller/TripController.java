package com.carpooling.controller;

import com.carpooling.model.Trip;
import com.carpooling.repository.TripRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips")
@CrossOrigin
public class TripController {
    private final TripRepository tripRepository;

    public TripController(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @GetMapping
    public List<Trip> getAll() {
        return tripRepository.findAll();
    }

    @GetMapping("/search")
    public List<Trip> search(@RequestParam String origin, @RequestParam String destination) {
        return tripRepository.findByOriginAndDestination(origin, destination);
    }

    @PostMapping
    public Trip create(@RequestBody Trip trip) {
        return tripRepository.save(trip);
    }
}

