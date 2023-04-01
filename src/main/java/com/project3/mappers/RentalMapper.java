package com.project3.mappers;

import com.project3.dtos.RentalDTO;
import com.project3.entities.Rental;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.web.multipart.MultipartFile;

@Mapper(componentModel = "spring")
public interface RentalMapper {

    @Mapping(source="rentalDTO.picture", target="picture", qualifiedByName = "multiPartToString")
    Rental RentalDTOToRental(RentalDTO rentalDTO);

    //RentalDTO RentalToRentalDTO(Rental rental);

    @Named("multiPartToString")
    public static String multiPartToString(MultipartFile multipartFile) {
        return multipartFile.getName();
    }
}
