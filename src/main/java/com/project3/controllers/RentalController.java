package com.project3.controllers;

import com.project3.dtos.RentalDTO;
import com.project3.entities.Rental;
import com.project3.mappers.RentalMapper;
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

    @Autowired
    RentalMapper rentalMapper;

    @GetMapping("/api/rentals")
    public RentalsResponse getRentals() {
        return rentalService.getRentals();
    }

    @GetMapping(path = "/api/rentals/{id}")
    public Rental detailRental(@PathVariable("id") Long rentalId) {
        return rentalService.getDetailRental(rentalId);
    }

    @PutMapping(path = "/api/rentals/{id}")
    public RentalResponse updateRental(@ModelAttribute Rental rental, @PathVariable String id) {
        //First we need to save the image from the original post
        Rental rental_for_picture = rentalService.getDetailRental(Long.parseLong(id));

        rental_for_picture.setName(rental.getName());
        rental_for_picture.setPrice(rental.getPrice());
        rental_for_picture.setSurface(rental.getSurface());
        rental_for_picture.setDescription(rental.getDescription());

        rental_for_picture.setUpdated_at(new Date());


        RentalResponse response = rentalService.save(rental_for_picture);
        return response;
    }

    // This form also adds an image (no image upload when updating)
    @PostMapping(path = "/api/rentals/create")
    public RentalResponse createDental(@ModelAttribute RentalDTO rentalDTO){

        // Missing fields from ModelAttribute.
        // So we need to create a new Rental and add ModelAttribute parameters
        // name - surface - price - (picture if creating) - description - owner_id
        Rental new_rental = rentalMapper.RentalDTOToRental(rentalDTO);
        //We also add a picture
        new_rental.setPicture(rentalDTO.getPicture());

        RentalResponse response = rentalService.save(new_rental);
        return response;
    }


}
