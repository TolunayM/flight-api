package com.example.flightapi.flight.Repository;

import com.example.flightapi.flight.Models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight,Integer> {

    //query for finding based on departure time
    @Query("SELECT f FROM Flight f " +
    "WHERE f.departureAirport.city = :departureAirport "+
    "AND f.arrivalAirport.city = :arrivalAirport " +
    "AND f.departureTime  = :departureTime")
    List<Flight> findOneWayFlights(
            @Param("departureAirport") String departureAirport,
            @Param("arrivalAirport") String arrivalAirport,
            @Param("departureTime") Date departureTime);

    //query for finding based on arrival time
    @Query("SELECT t FROM Flight t " +
    "WHERE t.departureAirport.city = :departureAirport " +
    "AND t.arrivalAirport.city = :arrivalAirport " +
    "AND t.arrivalTime = :arrivalTime")
    List<Flight> findTwoWayFlights(
            @Param("departureAirport") String departureAirport,
            @Param("arrivalAirport") String arrivalAirport,
            @Param("arrivalTime") Date arrivalTime
    );
}
