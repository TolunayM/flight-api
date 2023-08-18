package com.example.flightapi.flight.Service;


import com.example.flightapi.flight.Models.Airport;
import com.example.flightapi.flight.Repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;


    public List<Airport> getAllAirports(){
        return airportRepository.findAll();
    }

    public void createAirport(Airport airport){
        airportRepository.save(airport);
    }


    public void deleteAirport(Integer id){
        airportRepository.deleteById(id);
    }

    //TODO change this to updateByID
    public void updateAirport(Airport airport,Integer id){
        if(airportRepository.existsById(id)){
            airport.setId(id);
            airportRepository.save(airport);
        }
    }
}
