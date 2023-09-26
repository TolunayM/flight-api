package com.example.flightapi.flight.Service;

import com.example.flightapi.flight.Models.Flight;
import com.example.flightapi.flight.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class FlightService {

    
    private FlightRepository flightRepository;

    private FlightService(FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }

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

    public List<Flight> findOneWayFlights(String departureAirport, String arrivalAirport,Date departureTime){
        return flightRepository.findOneWayFlights(departureAirport,arrivalAirport,departureTime);
    }

    public List<Flight> findTwoWayFlights(String departureAirport, String arrivalAirport,Date arrivalTime){
        return flightRepository.findTwoWayFlights(departureAirport,arrivalAirport,arrivalTime);
    }

}
