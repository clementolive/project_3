package com.project3.dtos;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class RentalDTO {

    String name;
    Integer surface;
    Integer price;
    MultipartFile picture;
    String description;

}
