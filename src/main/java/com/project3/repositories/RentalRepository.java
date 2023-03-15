package com.project3.repositories;

import com.project3.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {


}
