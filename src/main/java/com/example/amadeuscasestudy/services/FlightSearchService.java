package com.example.amadeuscasestudy.services;

import com.example.amadeuscasestudy.entities.Flight;
import com.example.amadeuscasestudy.repositories.FlightRepository;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlightSearchService {

    final FlightRepository flightRepository;




    public ResponseEntity getFlights(Flight request) {

        if (request.getDepartureAirport() == null) {
            return new ResponseEntity<>("Departure airport is null", HttpStatus.BAD_REQUEST);
        }

        List<Flight> flights;

        if (request.getReturnTime() != null) {
            // Two-way flight
            flights = flightRepository.findByDepartureAirport_AidAndArrivalAirport_AidAndDepartureTimeAndReturnTime(
                    request.getDepartureAirport().getAid(),
                    request.getArrivalAirport().getAid(),
                    request.getDepartureTime(),
                    request.getReturnTime());
        } else {
            // One-way flight
            flights = flightRepository.findByDepartureAirport_AidAndArrivalAirport_AidAndDepartureTime(
                    request.getDepartureAirport().getAid(),
                    request.getArrivalAirport().getAid(),
                    request.getDepartureTime());
        }

        if (!flights.isEmpty()) {
            return new ResponseEntity<>(flights, HttpStatus.OK);
        }

        return new ResponseEntity<>("Flight Not Found", HttpStatus.BAD_REQUEST);
    }
}


