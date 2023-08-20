package com.example.flightapi.flight.Repository;

import com.example.flightapi.flight.Models.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport,Integer> {
}
