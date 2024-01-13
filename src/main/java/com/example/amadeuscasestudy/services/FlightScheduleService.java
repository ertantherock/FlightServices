package com.example.amadeuscasestudy.services;

import com.example.amadeuscasestudy.entities.Flight;
import com.example.amadeuscasestudy.repositories.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class FlightScheduleService {


    final FlightRepository flightRepository;


    final RestTemplate restTemplate;


    @Scheduled(cron = "0 0 12 * * *")
    public void fetchFlights() {
        String apiUrl = "http://localhost:8080/flight/data";

        Flight[] dummyFlights = restTemplate.getForObject(apiUrl, Flight[].class);

        if (dummyFlights != null) {
            flightRepository.saveAll(Arrays.asList(dummyFlights));
        }
    }
}
