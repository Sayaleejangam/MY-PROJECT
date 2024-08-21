package com.jspiders.cardekho.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.cardekho.Pojo.Car;
import com.jspiders.cardekho.Response.ResponseStructure;
import com.jspiders.cardekho.Service.CarService;

@RestController
@RequestMapping("/cars") 
public class CarController {
    
    @Autowired
    private CarService carService;

    @PostMapping 
    protected ResponseEntity<ResponseStructure<Car>> addCar(@RequestBody Car car) {
        Car addedCar = carService.addCar(car);
        ResponseStructure<Car> responseStructure = new ResponseStructure<Car>();
        responseStructure.setMessage("Car Added");
        responseStructure.setData(addedCar);
        responseStructure.setStatus(HttpStatus.OK.value());
        return ResponseEntity.ok(responseStructure);
    }

    @GetMapping 
    protected  ResponseEntity<ResponseStructure<List<Car>>> findAllCars() {
        List<Car> cars = carService.findAllCars();
        ResponseStructure<List<Car>> responseStructure = new ResponseStructure<>();
        if (cars != null && !cars.isEmpty()) {
            responseStructure.setMessage("Cars Found");
            responseStructure.setDatas(cars);
            responseStructure.setStatus(HttpStatus.OK.value());
            return ResponseEntity.ok(responseStructure);
        } else {
            responseStructure.setMessage("Cars Not Found");
            responseStructure.setData(null); // Since cars are not found, setting data to null
            responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseStructure);
        }
    }

    @PutMapping("/{carId}")
    protected ResponseEntity<ResponseStructure<Car>> updateCar(
            @PathVariable("carId") Integer carId,
            @RequestBody Car updatedCar) {
        Car car = carService.findCarById(carId);
        if (car != null) {
            updatedCar.setId(carId); // Ensure the ID is set to the same as the original car
            Car updated = carService.updateCar(updatedCar);
            ResponseStructure<Car> responseStructure = new ResponseStructure<>();
            responseStructure.setMessage("Car Updated");
            responseStructure.setData(updated);
            responseStructure.setStatus(HttpStatus.OK.value());
            return ResponseEntity.ok(responseStructure);
        } else {
            ResponseStructure<Car> responseStructure = new ResponseStructure<>();
            responseStructure.setMessage("Car Not Found");
            responseStructure.setData(null);
            responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseStructure);
        }
    }

    @DeleteMapping("/{carId}")
    protected ResponseEntity<ResponseStructure<Void>> deleteCar(@PathVariable("carId") Integer carId) {
        boolean deleted = carService.deleteCar(carId);
        ResponseStructure<Void> responseStructure = new ResponseStructure<>();
        if (deleted) {
            responseStructure.setMessage("Car Deleted");
            responseStructure.setStatus(HttpStatus.OK.value());
            return ResponseEntity.ok(responseStructure);
        } else {
            responseStructure.setMessage("Car Not Found");
            responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseStructure);
        }
    }
}

