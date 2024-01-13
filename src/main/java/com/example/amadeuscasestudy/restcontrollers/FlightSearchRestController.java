package com.example.amadeuscasestudy.restcontrollers;

import com.example.amadeuscasestudy.entities.Flight;
import com.example.amadeuscasestudy.services.FlightSearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/search")
@Api
public class FlightSearchRestController {


    final FlightSearchService flightSearchService;



    @PostMapping("/flight")
    @ApiOperation(value = "Search flight by parameters " +
            "{\n" +
            "  \"departureAirport\": {\n" +
            "    \"aid\": 4\n" +
            "  },\n" +
            "  \"arrivalAirport\": {\n" +
            "    \"aid\": 2\n" +
            "  },\n" +
            "  \"departureTime\": \"2025-01-11T15:30:00\",\n" +
            "  \"returnTime\": null\n" +
            "} Or you can add returnTime. It will return Two way flight ")
    public ResponseEntity<?> searchFlights(@RequestBody Flight request) {
        return flightSearchService.getFlights(request);
    }
}
