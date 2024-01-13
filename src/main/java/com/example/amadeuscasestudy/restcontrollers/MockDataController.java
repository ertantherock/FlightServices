package com.example.amadeuscasestudy.restcontrollers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mock")
public class MockDataController {

    @GetMapping("/data")
    public ResponseEntity<String> getFlightData() {
        // Your implementation here, return some dummy data for testing
        return ResponseEntity.ok("Flight data goes here");
    }


}
