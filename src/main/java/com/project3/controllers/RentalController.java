package com.project3.controllers;

import com.project3.dtos.RentalDTO;
import com.project3.entities.Rental;
import com.project3.mappers.RentalMapper;
import com.project3.models.RentalResponse;
import com.project3.models.RentalsResponse;
import com.project3.services.RentalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

@RestController
public class RentalController {
    @Autowired
    RentalService rentalService;
    @Autowired
    RentalMapper rentalMapper;

    @Operation(summary = "Get all rentals", description = "This get all the rentals in database to display them on a page.", tags = "Get")
    @GetMapping("/api/rentals")
    public RentalsResponse getRentals() {
        return rentalService.getRentals();
    }

    @Operation(summary = "Get a specific rental", description = "Gets a specific rental from its ID to display detailed informations about it.", tags = "Get")
    @GetMapping(path = "/api/rentals/{id}")
    public Rental detailRental(@Parameter(description = "A rental id") @PathVariable("id") Long rentalId) {
        return rentalService.getDetailRental(rentalId);
    }

    @Operation(summary = "Updates a rental", description = "Updates a rental updating with name, price, surface and description.", tags = "Put")
    @PutMapping(path = "/api/rentals/{id}")
    public RentalResponse updateRental(@ModelAttribute Rental rental,
                                       @Parameter(description = "The id of the rental to update") @PathVariable String id) {
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

    @Operation(summary = "Creates a rental", description = "Creates a new rental to display, with name, surface, price, description and picture.",
            tags = "Post")
    @PostMapping(path = "/api/rentals/create")
    public RentalResponse createDental(@ModelAttribute RentalDTO rentalDTO){

        // Missing fields from ModelAttribute.
        // So we need to create a new Rental and add ModelAttribute parameters
        // name - surface - price - (picture if creating) - description - owner_id
        Rental new_rental = rentalMapper.RentalDTOToRental(rentalDTO);
        //We also add a picture
        new_rental.setPicture(rentalDTO.getPicture());

        return rentalService.save(new_rental);
    }


}
