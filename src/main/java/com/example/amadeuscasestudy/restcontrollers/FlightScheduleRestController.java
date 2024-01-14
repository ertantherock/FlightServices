package com.example.amadeuscasestudy.restcontrollers;

import com.example.amadeuscasestudy.entities.ScheduledFlight;
import com.example.amadeuscasestudy.services.FlightScheduleService;
import com.example.amadeuscasestudy.services.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fetch")
public class FlightScheduleRestController {

    final FlightScheduleService flightScheduleService;
    final FlightService flightService;


    @GetMapping("/flightJob")
    public List<ScheduledFlight> read() {
        return flightScheduleService.saveScheduledFlightsToDb();
    }


}
