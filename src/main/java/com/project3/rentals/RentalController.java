package com.project3.rentals;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentalController {

    @GetMapping("/api/rentals")
    public RentalsResponse getRentals() {
        RentalsResponse rentalsResponse = new RentalsResponse();

        return rentalsResponse;
    }

}
