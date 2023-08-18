package com.example.flightapi.flight.Repository;

import com.example.flightapi.flight.Models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends JpaRepository<Flight,Integer> {
}
