package com.project3.models;

import com.project3.entities.Rental;
import lombok.Data;

import java.util.Date;

@Data
public class RentalsResponse {
    Rental[] rentals;

    public RentalsResponse(){
        rentals = new Rental[3];
        Rental r = new Rental(
                1,
                "test house 1",
                432,
                300,
                "https://blog.technavio.org/wp-content/uploads/2018/12/Online-House-Rental-Sites.jpg",
                "Lorem ipsum dolor sit amet.",
                1,
                new Date(),
                new Date());
        Rental r2 = new Rental(
                1,
                "test house 2",
                154,
                200,
                "https://blog.technavio.org/wp-content/uploads/2018/12/Online-House-Rental-Sites.jpg",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam a lectus eleifend, varius massa ac, mollis tortor. Quisque ipsum nulla, faucibus ac metus a, eleifend efficitur augue. Integer vel pulvinar ipsum. Praesent mollis neque sed sagittis ultricies. Suspendisse congue ligula at justo molestie, eget cursus nulla tincidunt. Pellentesque elementum rhoncus arcu, viverra gravida turpis mattis in. Maecenas tempor elementum lorem vel ultricies. Nam tempus laoreet eros, et viverra libero tincidunt a. Nunc vel nisi vulputate, sodales massa eu, varius erat.",
                2,
                new Date(),
                new Date());
        Rental r3 = new Rental(
                3,
                "test house 3",
                234,
                100,
                "https://blog.technavio.org/wp-content/uploads/2018/12/Online-House-Rental-Sites.jpg",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam a lectus eleifend, varius massa ac, mollis tortor. Quisque ipsum nulla, faucibus ac metus a, eleifend efficitur augue. Integer vel pulvinar ipsum. Praesent mollis neque sed sagittis ultricies. Suspendisse congue ligula at justo molestie, eget cursus nulla tincidunt. Pellentesque elementum rhoncus arcu, viverra gravida turpis mattis in. Maecenas tempor elementum lorem vel ultricies. Nam tempus laoreet eros, et viverra libero tincidunt a. Nunc vel nisi vulputate, sodales massa eu, varius erat.",
                1,
                new Date(),
                new Date());
        rentals[0] = r;
        rentals[1] = r2;
        rentals[2] = r3;
    }
}
