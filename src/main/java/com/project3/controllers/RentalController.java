package com.project3.controllers;

import com.project3.dtos.RentalDTO;
import com.project3.entities.Rental;
import com.project3.entities.User;
import com.project3.mappers.RentalMapper;
import com.project3.models.RentalResponse;
import com.project3.models.RentalsResponse;
import com.project3.services.FilesStorageService;
import com.project3.services.RentalService;
import com.project3.services.auth.JwtUserDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.net.URI;
import java.util.Date;

@RestController
public class RentalController {
    @Autowired
    RentalService rentalService;
    @Autowired
    RentalMapper rentalMapper;
    @Autowired
    JwtUserDetailsService jwtUserDetailsService;
    @Autowired
    FilesStorageService storageService;

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

        return rentalService.save(rental_for_picture);
    }

    @Operation(summary = "Creates a rental", description = "Creates a new rental to display, with name, surface, price, description and picture.",
            tags = "Post")
    @PostMapping(path = "/api/rentals")
    public RentalResponse createDental(@ModelAttribute RentalDTO rentalDTO) throws IOException {

        Rental new_rental = rentalMapper.RentalDTOToRental(rentalDTO);

        //We now need owner_ID, created_at, updated_at
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User my_user = jwtUserDetailsService.loadUserByUsername(username);
        new_rental.setOwner_id(my_user.getId());

        new_rental.setCreated_at(new Date());
        new_rental.setUpdated_at(new Date());

        //Saving picture in server
        storageService.save(rentalDTO.getPicture());

        //Creating and saving picture URL
        new_rental.setPicture(String.valueOf(URI.create("http://localhost:4200/api/images/" + rentalDTO.getPicture().getOriginalFilename())));

        return rentalService.save(new_rental);
    }

}
