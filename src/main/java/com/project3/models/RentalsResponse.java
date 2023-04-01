package com.project3.models;

import com.project3.entities.Rental;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Stores all rentals in an array for Rentals page")
public class RentalsResponse {
    Rental[] rentals;

    public RentalsResponse(){
        rentals = new Rental[3];
    }
}
