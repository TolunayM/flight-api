package com.example.flightapi.flight.Controller;

import com.example.flightapi.flight.Models.Flight;
import com.example.flightapi.flight.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/flightapi/v1/search")
public class FlightSearchController {

    
    private FlightService flightService;

    private FlightSearchController(FlightService flightService){
        this.flightService = flightService;
    }

    //Check for arrivalTime if it's not null return list with rotated airports
    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> searchFlights(
            @RequestParam String departureAirport,
            @RequestParam String arrivalAirport,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date departureTime,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date arrivalTime
    ) {
        List<Flight> flights = flightService.findOneWayFlights(departureAirport, arrivalAirport, departureTime);
        Map<String, Object> flightMap = new HashMap<>();
        List<Map<String, Object>> response = new ArrayList<>();
        for (Flight flight : flights) {
            flightMap.put("id" ,flight.getId());
            flightMap.put("departureAirportID",flight.getDepartureAirport().getId());
            flightMap.put("departureAirport", flight.getDepartureAirport().getCity());
            flightMap.put("arrivalAirportID",flight.getArrivalAirport().getId());
            flightMap.put("arrivalAirport", flight.getArrivalAirport().getCity());
            flightMap.put("departureTime",flight.getDepartureTime());
            flightMap.put("arrivalTime",flight.getArrivalTime());

        }
        response.add(flightMap);
        if(arrivalTime != null){
            Map<String, Object> flightMap2 = new HashMap<>();
            List<Flight> arrivalList = flightService.findTwoWayFlights(departureAirport,arrivalAirport,arrivalTime);
            for (Flight flight : arrivalList) {
                flightMap2.put("id" ,flight.getId());
                flightMap2.put("departureAirportID",flight.getArrivalAirport().getId());
                flightMap2.put("departureAirport", flight.getArrivalAirport().getCity());
                flightMap2.put("arrivalAirportID",flight.getDepartureAirport().getId());
                flightMap2.put("arrivalAirport", flight.getDepartureAirport().getCity());
                flightMap2.put("departureTime",flight.getDepartureTime());
                flightMap2.put("arrivalTime",flight.getArrivalTime());

        }
            response.add(flightMap2);
        }

        return ResponseEntity.ok(response);
    }
        }










