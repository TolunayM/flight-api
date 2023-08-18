package com.example.flightapi.flight.Service;

import com.example.flightapi.flight.Models.Flight;
import com.example.flightapi.flight.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }

    public void createFlight(Flight flight){
        flightRepository.save(flight);
    }

    public void updateFlight(Flight flight,Integer id){
        if(flightRepository.existsById(id)){
            flight.setId(id);
            flightRepository.save(flight);
        }
    }

    public void deleteFlight(Integer id){
        flightRepository.deleteById(id);
    }

}
