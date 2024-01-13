package com.example.amadeuscasestudy.entities;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aid;
    private String airportCity;


}
