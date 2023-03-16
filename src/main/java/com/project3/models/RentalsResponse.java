package com.project3.models;

import com.project3.entities.Rental;
import lombok.Data;

@Data
public class RentalsResponse {
    Rental[] rentals;

    public RentalsResponse(){
        rentals = new Rental[3];
    }
}
