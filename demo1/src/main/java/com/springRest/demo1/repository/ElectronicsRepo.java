package com.springRest.demo1.repository;

import com.springRest.demo1.entities.Electronics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectronicsRepo extends JpaRepository<Electronics,Long> {
}
