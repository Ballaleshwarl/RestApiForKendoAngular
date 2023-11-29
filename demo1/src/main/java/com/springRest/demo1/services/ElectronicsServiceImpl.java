package com.springRest.demo1.services;

import com.springRest.demo1.entities.Electronics;
import com.springRest.demo1.repository.ElectronicsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ElectronicsServiceImpl implements  ElectronicsService{



    @Autowired
   private   ElectronicsRepo electronicsRe;
    @Override
    public List<Electronics> getElectronics() {
        return electronicsRe.findAll();
    }
}
