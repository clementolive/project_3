package com.project3.user;

import com.project3.rentals.RentalResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class UserController {

    @GetMapping("/api/user/{id}")
    public User registerNewUser(@PathVariable("id") Integer userId){
        //userService.addNewStudent(userId);
        return new User(2, "Owner name", "owner@owner.com", new Date(), new Date());
    }

}
