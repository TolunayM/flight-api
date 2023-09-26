package com.example.flightapi.flight.Controller;


import com.example.flightapi.flight.Models.Flight;
import com.example.flightapi.flight.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/flightapi/v1/flights")
@RestController
public class FlightController {

    private FlightService flightService;

    private FlightController(FlightService flightService){
        this.flightService = flightService;
    }

    @RequestMapping(method = RequestMethod.GET,value ="/all-flights")
    public List<Flight> getAllFlights(){
        return flightService.getAllFlights();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/add-flight")

    public void createFlight(@RequestBody Flight flight){
        flightService.createFlight(flight);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/update-flight/{id}")
    public void updateFlight(@RequestBody Flight flight, @PathVariable Integer id){
        flightService.updateFlight(flight,id);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/delete-flight/{id}")
    public void deleteFlight(@PathVariable Integer id){
        flightService.deleteFlight(id);
    }
}
