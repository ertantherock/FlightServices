package com.example.amadeuscasestudy.repositories;

import com.example.amadeuscasestudy.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
}