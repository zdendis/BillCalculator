package com.phonecompany.billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BillCalculator {
    @Autowired
    private TelephoneBillCalculator calculator;

    public static void main(String[] args) {
        SpringApplication.run(BillCalculator.class, args);
    }
}
