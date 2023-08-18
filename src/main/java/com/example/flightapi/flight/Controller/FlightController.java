package com.example.flightapi.flight.Controller;


import com.example.flightapi.flight.Models.Flight;
import com.example.flightapi.flight.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController {

    @Autowired
    private FlightService flightService;

    @RequestMapping(method = RequestMethod.GET,value ="/flightapi/v1/all-flights")
    public List<Flight> getAllFlights(){
        return flightService.getAllFlights();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/flightapi/v1/add-flight")
    public void createFlight(@RequestBody Flight flight){
        flightService.createFlight(flight);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/flightapi/v1/update-flight/{id}")
    public void updateFlight(@RequestBody Flight flight, @PathVariable Integer id){
        flightService.updateFlight(flight,id);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/flightapi/v1/delete-flight/{id}")
    public void deleteFlight(@PathVariable Integer id){
        flightService.deleteFlight(id);
    }
}
