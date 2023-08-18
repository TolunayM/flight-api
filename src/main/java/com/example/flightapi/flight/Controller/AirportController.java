package com.example.flightapi.flight.Controller;


import com.example.flightapi.flight.Models.Airport;
import com.example.flightapi.flight.Models.Flight;
import com.example.flightapi.flight.Service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AirportController {

    @Autowired
    private AirportService airportService;

    @RequestMapping(method = RequestMethod.GET,value ="/flightapi/v1/get-airports")
    public List<Airport> getAllAirports(){
        return airportService.getAllAirports();
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/flightapi/v1/delete-airport/{id}")
    public void deleteAirport(@PathVariable Integer id){
        airportService.deleteAirport(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/flightapi/v1/add-airport")
    public void createAirport(@RequestBody Airport airport){
        airportService.createAirport(airport);
    }


    @RequestMapping(method = RequestMethod.PUT,value = "/flightapi/v1/update-airport/{id}")
    public void updateAirport(@RequestBody Airport airport, @PathVariable Integer id){
        airportService.updateAirport(airport,id);
    }
}
