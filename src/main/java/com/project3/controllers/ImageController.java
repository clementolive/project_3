package com.project3.controllers;

import com.project3.services.FilesStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class ImageController {

    @Autowired
    FilesStorageService storageService;

    @GetMapping(path = "/api/images/{filename}")
    public Resource getImage (@PathVariable String filename){
        return storageService.load(filename);
    }
}
