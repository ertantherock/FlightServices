package com.example.amadeuscasestudy.entities;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aid;


    @NotBlank
    @NotEmpty
    @NotNull(message = "Airport city cannot be null")
    private String airportCity;


}
