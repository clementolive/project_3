package com.project3.config;

import com.project3.entities.Rental;
import com.project3.repositories.RentalRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Date;
import java.util.List;

@Configuration
public class RentalsConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(RentalRepository rentalRepository){
        return args -> {
            Rental r = new Rental(
                    1,
                    "test house 1",
                    432,
                    300,
                    "https://blog.technavio.org/wp-content/uploads/2018/12/Online-House-Rental-Sites.jpg",
                    "Description 1",
                    1,
                    new Date(),
                    new Date());
            Rental r2 = new Rental(
                    2,
                    "test house 2",
                    154,
                    200,
                    "https://blog.technavio.org/wp-content/uploads/2018/12/Online-House-Rental-Sites.jpg",
                    "Description 2",
                    1,
                    new Date(),
                    new Date());
            Rental r3 = new Rental(
                    3,
                    "test house 3",
                    234,
                    100,
                    "https://blog.technavio.org/wp-content/uploads/2018/12/Online-House-Rental-Sites.jpg",
                    "Description 3",
                    1,
                    new Date(),
                    new Date());
            rentalRepository.saveAll(List.of(r, r2, r3));
        };
    }
}
