package com.jspiders.cardekho.Service;
import java.util.List;

import org.springframework.stereotype.Service;
import com.jspiders.cardekho.Pojo.Car;
import com.jspiders.cardekho.Repository.CarRepository;

@Service
public class CarService {

	private CarRepository carRepository;
	
	public Car addCar(Car car) {
		return carRepository.save(car);
	}

	public List<Car> findAllCars() {
		return carRepository.findAll();
	}

	public Car findCarById(int carId) {
		
		return findCarById(carId);
	}

	public Car updateCar(Car updatedCar) {
		
		return updateCar(updatedCar);
	}

	public boolean deleteCar(Integer carId) {
		
		return deleteCar(carId);
	}

}
