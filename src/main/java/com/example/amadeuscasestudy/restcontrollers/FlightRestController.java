package com.example.amadeuscasestudy.restcontrollers;

import com.example.amadeuscasestudy.entities.Flight;
import com.example.amadeuscasestudy.services.FlightSearchService;
import com.example.amadeuscasestudy.services.FlightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/flight")
@Api
public class FlightRestController {

    final FlightService flightService;
    final FlightSearchService flightSearchService;


    @PostMapping("/saveFlight")
    @ApiOperation(value = "New Flight adding method")
    public ResponseEntity save(@Valid @RequestBody Flight flight){
        return flightService.save(flight);
    }

    @GetMapping("/deleteFlight/{fid}")
    @ApiOperation(value = "New Flight delete method")
    public ResponseEntity delete( @PathVariable Long fid){
        return flightService.delete(fid);
    }

    @PostMapping("/update")
    @ApiOperation(value = "New Flight update method")
    public ResponseEntity update (@Valid @RequestBody Flight flight){
        return flightService.update(flight);
    }

    @GetMapping("/list")
    @ApiOperation(value = "All Flights list method")
    public ResponseEntity list(){
        return flightService.list();
    }

    @GetMapping("/list/{fid}")
    @ApiOperation(value = "Specific flight list by id")
    public ResponseEntity getSingleFlightById (@RequestBody @PathVariable Long fid ){
        return flightService.getSingleFlight(fid);
    }








    }






