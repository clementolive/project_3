package com.project3.services;

import com.project3.entities.Rental;
import com.project3.models.RentalsResponse;
import com.project3.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalService {
    @Autowired
    RentalRepository rentalRepository;

   public Rental getDetailRental(Long id){
       return rentalRepository.findById(id).orElse(new Rental());
   }

    public RentalsResponse getRentals() {
       RentalsResponse rentalsResponse = new RentalsResponse();
       //rentalsResponse.setRentals((Rental[]) rentalRepository.findAll().toArray());
       return rentalsResponse;
    }
}
