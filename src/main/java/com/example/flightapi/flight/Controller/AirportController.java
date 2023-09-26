package com.example.flightapi.flight.Controller;


import com.example.flightapi.flight.Models.Airport;
import com.example.flightapi.flight.Service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/flightapi/v1/airport")
@RestController
public class AirportController {

    private AirportService airportService;

    private AirportController(AirportService airportService){
        this.airportService = airportService;
    }

    @RequestMapping(method = RequestMethod.GET,value ="/all-airports")
    public List<Airport> getAllAirports(){
        return airportService.getAllAirports();
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/delete-airport/{id}")
    public void deleteAirport(@PathVariable Integer id){
        airportService.deleteAirport(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/add-airport")
    public void createAirport(@RequestBody Airport airport){
        airportService.createAirport(airport);
    }


    @RequestMapping(method = RequestMethod.PUT,value = "/update-airport/{id}")
    public void updateAirport(@RequestBody Airport airport, @PathVariable Integer id){
        airportService.updateAirport(airport,id);
    }
}
