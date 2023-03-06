package com.project3.rentals;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentalController {

    @GetMapping("/rentals")
    public String getRentals(){
        //System.out.println("hello");
        return "rentals";
    }
}
