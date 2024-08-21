package com.jspiders.cardekho.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jspiders.cardekho.Pojo.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

	List<Car> findAll(); // Corrected method signature to follow Spring Data JPA naming convention

}
