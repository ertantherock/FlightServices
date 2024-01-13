package com.example.amadeuscasestudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AmadeusCaseStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmadeusCaseStudyApplication.class, args);
    }

}
