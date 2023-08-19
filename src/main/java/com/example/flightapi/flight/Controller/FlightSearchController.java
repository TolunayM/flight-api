package com.example.flightapi.flight.Controller;

import com.example.flightapi.flight.Models.Flight;
import com.example.flightapi.flight.Repository.FlightRepository;
import com.example.flightapi.flight.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/flightapi/v1/search")
public class FlightSearchController {

    @Autowired
    private FlightService flightService;

    @GetMapping

    public List<Flight> findFlights(@RequestParam String departureAirport,@RequestParam String arrivalAirport,@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date departureTime,@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date arrivalTime)
    {
        if(arrivalTime == null){
            return flightService.findOneWayFlights(departureAirport,arrivalAirport,departureTime);
        }else{
            return flightService.findTwoWayFlights(departureAirport,arrivalAirport,arrivalTime);
        }

    }







}
