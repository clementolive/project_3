package com.project3.mappers;

import com.project3.dtos.RentalDTO;
import com.project3.entities.Rental;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RentalMapper {

    Rental RentalDTOToRental(RentalDTO rentalDTO);

    RentalDTO RentalToRentalDTO(Rental rental);
}
