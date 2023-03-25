package com.project3.services;

import com.project3.entities.Rental;
import com.project3.models.RentalResponse;
import com.project3.models.RentalsResponse;
import com.project3.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {
    @Autowired
    RentalRepository rentalRepository;

   public Rental getDetailRental(Long id){
       return rentalRepository.findById(id).orElse(new Rental());
   }

    public RentalsResponse getRentals() {
       RentalsResponse rentalsResponse = new RentalsResponse();
       Rental[] rentalList = rentalRepository.findAll().toArray(new Rental[0]);
       rentalsResponse.setRentals(rentalList);
       return rentalsResponse;
    }

    public RentalResponse save(Rental rental){
        rentalRepository.save(rental);
       return new RentalResponse("rental saved");
    }
}
