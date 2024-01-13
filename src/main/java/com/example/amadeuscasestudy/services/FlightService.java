package com.example.amadeuscasestudy.services;

import com.example.amadeuscasestudy.configs.Rest;
import com.example.amadeuscasestudy.entities.Flight;
import com.example.amadeuscasestudy.repositories.FlightRepository;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlightService {

    final FlightRepository flightRepository;

    public ResponseEntity save(Flight flight){
        try{
            flightRepository.save(flight);
            Rest rest = new Rest(true,flight);
            return new ResponseEntity(rest, HttpStatus.OK);
        }catch (Exception ex){
            Rest rest = new Rest(false,ex.getMessage());
            return new ResponseEntity(rest,HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity delete(Long fid){
        try{
            flightRepository.deleteById(fid);
            Rest rest = new Rest(true,fid);
            return new ResponseEntity(rest, HttpStatus.OK);
        }catch (Exception ex){
            Rest rest = new Rest(false,ex.getMessage());
            return new ResponseEntity(rest,HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity update(Flight flight){
        Optional<Flight> optionalFlight = flightRepository.findById(flight.getFid());
        if(optionalFlight.isPresent()){
            flightRepository.saveAndFlush(flight);
            Rest rest = new Rest(true,flight);
            return new ResponseEntity(rest,HttpStatus.OK);
        }
        Rest rest = new Rest(false,flight);
        return new ResponseEntity(rest,HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity list(){
        List<Flight> ls = flightRepository.findAll();
        Rest rest = new Rest(true,ls);
        return new ResponseEntity(rest,HttpStatus.OK);
    }

    public ResponseEntity getSingleFlight (Long fid) {
        Optional<Flight> optionalFlight = flightRepository.findById(fid);
        if (optionalFlight.isPresent()){

            return new ResponseEntity(optionalFlight.get(),HttpStatus.OK);
        }

        return new ResponseEntity("Flight Not Found Failed !",HttpStatus.BAD_REQUEST);
    }



}
