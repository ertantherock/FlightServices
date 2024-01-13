package com.example.amadeuscasestudy.services;

import com.example.amadeuscasestudy.entities.Flight;
import com.example.amadeuscasestudy.repositories.FlightRepository;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlightSearchService {

    final FlightRepository flightRepository;

    public ResponseEntity getFlights (Long did, Long aid, LocalDateTime departureTime, LocalDateTime returnTime) {
        Optional<Flight> optionalFlight = flightRepository.findByDepartureAirport_AidAndArrivalAirport_AidAndDepartureTimeAndReturnTime(did, aid, departureTime, returnTime);
        Optional<Flight> optionalFlight2 = flightRepository.findByDepartureAirport_AidAndArrivalAirport_AidAndDepartureTime(did, aid, departureTime);

        if (optionalFlight.isPresent() & returnTime != null){

            return new ResponseEntity(optionalFlight.get(), HttpStatus.OK);
        }else if (optionalFlight.isPresent() & returnTime == null){

            return new ResponseEntity(optionalFlight2.get(), HttpStatus.OK);

        }

        return new ResponseEntity("Flight Not Found Failed !",HttpStatus.BAD_REQUEST);
    }


    public Optional<Flight> searchFlights(Long did, Long aid, LocalDateTime departureTime, LocalDateTime returnTime) {
        if (returnTime != null) {
            System.out.println("Two Way Flight");
            return searchRoundTripFlights(did, aid, departureTime, returnTime);
        } else {
            System.out.println("One Way Flight");
            return searchOneWayFlight(did, aid, departureTime) ;
        }
    }

    private Optional<Flight> searchOneWayFlight(Long did, Long aid, LocalDateTime departureTime) {
        return flightRepository.findByDepartureAirport_AidAndArrivalAirport_AidAndDepartureTime(
                did, aid, departureTime);
    }


    private Optional<Flight> searchRoundTripFlights(Long did, Long aid, LocalDateTime departureTime, LocalDateTime returnTime) {
        return flightRepository.findByDepartureAirport_AidAndArrivalAirport_AidAndDepartureTimeAndReturnTime(
                did, aid, departureTime, returnTime);

    }

}
