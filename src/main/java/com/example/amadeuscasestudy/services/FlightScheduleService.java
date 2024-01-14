package com.example.amadeuscasestudy.services;

import com.example.amadeuscasestudy.entities.ScheduledFlight;
import com.example.amadeuscasestudy.repositories.ScheduledFlightsRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class FlightScheduleService {

    final ScheduledFlightsRepository scheduledFlightsRepository;

    //Get Data from XML web service and save

    @Scheduled(cron = "0 0 0 * * *") // Run every day at midnight
    public List<ScheduledFlight> saveScheduledFlightsToDb() {
        try {
            String url = "https://run.mocky.io/v3/5283c63c-c479-472d-bfe2-91767a7296c5";
            String stData = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get().toString();
            Document doc = Jsoup.parse(stData, Parser.xmlParser());
            Elements elements = doc.getElementsByTag("row");

            List<ScheduledFlight> scheduledFlightList = new ArrayList<>();

            for (Element item : elements) {
                String departureAirportId = item.getElementsByTag("departureAirport").text();
                String arrivalAirportId = item.getElementsByTag("arrivalAirport").text();
                String departureTime = item.getElementsByTag("departureTime").text();
                String returnTime = item.getElementsByTag("returnTime").text();
                String price = item.getElementsByTag("price").text();

                ScheduledFlight scheduledFlight = new ScheduledFlight(departureAirportId, arrivalAirportId, departureTime, returnTime, price);
                scheduledFlightList.add(scheduledFlight);
            }

            // Save to the database using ScheduledFlightsRepository
            scheduledFlightsRepository.saveAll(scheduledFlightList);
            System.out.println("Scheduled Flights Saved!");
        } catch (Exception ex) {
            System.err.println("Result Error: " + ex);
        }
        return null;
    }

}
