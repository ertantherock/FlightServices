package com.example.amadeuscasestudy.repositories;

import com.example.amadeuscasestudy.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    Optional<Flight> findByDepartureAirport_AidAndArrivalAirport_AidAndDepartureTimeAndReturnTime(Long did, Long aid, LocalDateTime departureTime, LocalDateTime returnTime);

    Optional<Flight> findByDepartureAirport_AidAndArrivalAirport_AidAndDepartureTime(Long did, Long aid, LocalDateTime departureTime);


    
    
    
    

}