package com.example.flightapi.flight.Service;


import com.example.flightapi.flight.Models.Airport;
import com.example.flightapi.flight.Repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {

    
    private AirportRepository airportRepository;

    private AirportService(AirportRepository airportRepository){
        this.airportRepository = airportRepository;
    }

    public List<Airport> getAllAirports(){
        return airportRepository.findAll();
    }

    public void createAirport(Airport airport){
        airportRepository.save(airport);
    }

    public void deleteAirport(Integer id){
        airportRepository.deleteById(id);
    }

    public void updateAirport(Airport airport,Integer id){
        if(airportRepository.existsById(id)){
            airport.setId(id);
            airportRepository.save(airport);
        }
    }
}
