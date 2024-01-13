package com.example.amadeuscasestudy.restcontrollers;

import com.example.amadeuscasestudy.services.FlightScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fetch")
public class FlightScheduleRestController {

    final FlightScheduleService flightScheduleService;

    @GetMapping("/flightJob")
    public String startFlightFetchJob() {
        flightScheduleService.fetchFlights();
        return "Fetch job has begin";
    }
}
