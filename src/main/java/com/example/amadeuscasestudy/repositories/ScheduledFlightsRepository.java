package com.example.amadeuscasestudy.repositories;

import com.example.amadeuscasestudy.entities.ScheduledFlight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduledFlightsRepository extends JpaRepository<ScheduledFlight, Long> {
}