package com.project3.controllers;

import com.project3.entities.Rental;
import com.project3.models.RentalResponse;
import com.project3.models.RentalsResponse;
import com.project3.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class RentalController {
    @Autowired
    RentalService rentalService;

    @GetMapping("/api/rentals")
    public RentalsResponse getRentals() {
        //RentalsResponse rentalsResponse = new RentalsResponse();

        return rentalService.getRentals();
    }

    //TODO : We must differentiate here between update and detail in rentals/:id
    @GetMapping(path = "/api/rentals/{id}")
    public Rental detailRental(@PathVariable("id") Long rentalId) {
        return rentalService.getDetailRental(rentalId);
    }

    //TODO : Code for Updating a rental
    @PutMapping(path = "/api/rentals/{id}")
    public RentalResponse updateRental(@PathVariable("id") Integer rentalId) {
        RentalResponse rentalResponse = new RentalResponse("Rental updated !");

        return rentalResponse;
    }

}
