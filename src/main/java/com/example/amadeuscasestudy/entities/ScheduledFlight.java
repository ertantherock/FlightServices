package com.example.amadeuscasestudy.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@RequiredArgsConstructor
public class ScheduledFlight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;

    private String departureAirport;

    private String arrivalAirport;

    private String departureTime;

    private String returnTime;

    private String price;

    public ScheduledFlight(String departureAirport, String arrivalAirport, String departureTime, String returnTime, String price) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureTime = departureTime;
        this.returnTime = returnTime;
        this.price = price;
    }
}
