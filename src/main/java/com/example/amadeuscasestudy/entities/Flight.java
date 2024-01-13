package com.example.amadeuscasestudy.entities;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fid;

    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    private Airport arrivalAirport;


    @NotNull(message = "Departure time cannot be null")
    private LocalDateTime departureTime;


    private LocalDateTime returnTime;

    @NotNull(message = "Price cannot be null")
    @Min(message = "Price cannot be lower than zero", value = 0)
    private Integer price;





}
