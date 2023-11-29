package com.springRest.demo1.controller;

import com.springRest.demo1.entities.Electronics;
import com.springRest.demo1.services.ElectronicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ElectronicsController
{


    @Autowired
    private ElectronicsService electronicsService;

    @CrossOrigin(origins ="http://localhost:4200")
    @GetMapping("/getElectronics")
    public List<Electronics> getElectronics(){
        return  electronicsService.getElectronics();
    }
}
