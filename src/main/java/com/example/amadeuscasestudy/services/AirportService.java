package com.example.amadeuscasestudy.services;

import com.example.amadeuscasestudy.configs.Rest;
import com.example.amadeuscasestudy.entities.Airport;
import com.example.amadeuscasestudy.entities.Flight;
import com.example.amadeuscasestudy.repositories.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AirportService {

    final AirportRepository airportRepository;

    public ResponseEntity saveAirport(Airport airport){
        try{
            airportRepository.save(airport);
            Rest rest = new Rest(true,airport);
            return new ResponseEntity(rest, HttpStatus.OK);
        }catch (Exception ex){
            Rest rest = new Rest(false,ex.getMessage());
            return new ResponseEntity(rest,HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity deleteAirport(Long aid){
        try{
            airportRepository.deleteById(aid);
            Rest rest = new Rest(true,aid);
            return new ResponseEntity(rest, HttpStatus.OK);
        }catch (Exception ex){
            Rest rest = new Rest(false,ex.getMessage());
            return new ResponseEntity(rest,HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity updateAirport(Airport airport){
        Optional<Airport> optionalAirport = airportRepository.findById(airport.getAid());
        if(optionalAirport.isPresent()){
            airportRepository.saveAndFlush(airport);
            Rest rest = new Rest(true,airport);
            return new ResponseEntity(rest,HttpStatus.OK);
        }
        Rest rest = new Rest(false,airport);
        return new ResponseEntity(rest,HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity list(){
        List<Airport> ls = airportRepository.findAll();
        Rest rest = new Rest(true,ls);
        return new ResponseEntity(rest,HttpStatus.OK);
    }







}
