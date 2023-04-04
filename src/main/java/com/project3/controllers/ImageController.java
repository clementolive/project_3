package com.project3.controllers;

import com.project3.services.FilesStorageService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

    @Autowired
    FilesStorageService storageService;

    @Operation(summary = "Load an image", description = "We use the file system to load an image, with URL variable", tags = "Get")
    @GetMapping(path = "/api/images/{filename}")
    public Resource getImage (@PathVariable String filename){
        return storageService.load(filename);
    }
}
