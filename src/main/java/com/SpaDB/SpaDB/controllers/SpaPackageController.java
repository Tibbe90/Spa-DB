package com.SpaDB.SpaDB.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpaDB.SpaDB.models.SpaPackage;

@RestController
public class SpaPackageController {
    
    @GetMapping("/SpaPackages")
    public List<SpaPackage> spaPackages() {
        return null;
    }

}
