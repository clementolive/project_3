package com.project3.controllers;

import com.project3.dtos.RentalDTO;
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
        return rentalService.getRentals();
    }

    @GetMapping(path = "/api/rentals/{id}")
    public Rental detailRental(@PathVariable("id") Long rentalId) {
        return rentalService.getDetailRental(rentalId);
    }

    //TODO : Code for Updating a rental (from FormData)
    @PutMapping(path = "/api/rentals/{id}")
    public RentalResponse updateRental(@PathVariable("id") Long rentalId) {
        Rental rental = rentalService.getDetailRental(rentalId);


        RentalResponse rentalResponse = new RentalResponse("Rental updated !");
        return rentalResponse;
    }

    //TODO : Code for Creating a rental (from FormData)
    @PostMapping(path = "/api/rentals/create")
    public RentalResponse createDental(@ModelAttribute RentalDTO rentalDTO){

        RentalResponse rentalResponse = new RentalResponse("Rental updated !");
        return rentalResponse;
    }


}
