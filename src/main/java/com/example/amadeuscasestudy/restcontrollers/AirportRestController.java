package com.example.amadeuscasestudy.restcontrollers;

import com.example.amadeuscasestudy.configs.Rest;
import com.example.amadeuscasestudy.entities.Airport;
import com.example.amadeuscasestudy.entities.Flight;
import com.example.amadeuscasestudy.services.AirportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/airport")
@Api
public class AirportRestController {

    final AirportService airportService;

    @PostMapping("/saveAirport")
    @ApiOperation(value = "New airport add method")
    public ResponseEntity save(@Valid @RequestBody Airport airport){
        return airportService.saveAirport(airport);
    }

    @DeleteMapping("/deleteAirport/{aid}")
    @ApiOperation(value = "New airport delete method")
    public ResponseEntity delete( @PathVariable Long aid){
        return airportService.deleteAirport(aid);
    }

    @PutMapping("/updateAirport")
    @ApiOperation(value = "New airport update method")
    public ResponseEntity update (@Valid @RequestBody Airport airport){
        return airportService.updateAirport(airport);
    }

    @GetMapping("/listAirport")
    @ApiOperation(value = "All airport list method")
    public ResponseEntity list() {
        return airportService.list();
    }


}
