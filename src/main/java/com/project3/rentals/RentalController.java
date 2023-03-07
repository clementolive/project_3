package com.project3.rentals;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class RentalController {

    @GetMapping("/api/rentals")
    public RentalsResponse getRentals() {
        RentalsResponse rentalsResponse = new RentalsResponse();

        return rentalsResponse;
    }

    //TODO : We must differentiate here between update and detail in rentals/:id
    @GetMapping(path = "/api/rentals/{id}")
    public Rental detailRental(@PathVariable("id") Integer rentalId) {
        Rental rental = new Rental(1, "test house 1", 432, 300,
                "https://blog.technavio.org/wp-content/uploads/2018/12/Online-House-Rental-Sites.jpg",
                "Lorem ipsum dolor sit amet.",
                1,
                "2012/12/02",
                "2014/12/02");

        return rental;
    }

    @PutMapping(path = "/api/rentals/{id}")
    public RentalResponse updateRental(@PathVariable("id") Integer rentalId) {
        RentalResponse rentalResponse = new RentalResponse("Rental updated !");

        return rentalResponse;
    }

}
