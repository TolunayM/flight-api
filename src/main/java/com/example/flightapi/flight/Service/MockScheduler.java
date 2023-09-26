package com.example.flightapi.flight.Service;

import com.example.flightapi.flight.Models.Flight;
import com.example.flightapi.flight.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MockScheduler {

    
    private FlightRepository flightRepository;

    private MockScheduler(FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }

    @Scheduled(cron = "0 0 1 * * ?") //call every day at 01.00
    public void fetchAndSaveFlights() {
        List<Flight> mockFlights = fetchMockFlights();
        flightRepository.saveAll(mockFlights);
    }

    private List<Flight> fetchMockFlights() {
        //Can make api call here for mock data
        List<Flight> mockFlights = new ArrayList<>();


        Flight flight1 = new Flight();
        Flight flight2 = new Flight();

        mockFlights.add(flight1);
        mockFlights.add(flight2);

        return mockFlights;
}}
