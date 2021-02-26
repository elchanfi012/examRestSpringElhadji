package com.humanbooster.exam_rest_elhadji_chanfi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.humanbooster.exam_rest_elhadji_chanfi.models.Car;
import com.humanbooster.exam_rest_elhadji_chanfi.services.CarService;

@RestController
@RequestMapping("/api")
public class CarController {
	
	@Autowired
	private CarService carService;

	@GetMapping("/cars")
	public List<Car> getCars(){
		return carService.getCars();
	}
	
	@GetMapping("/cars/{car}")
	public Car getCarById(@PathVariable(name = "car", required = false) Car car) {
		if(car == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Car Not Found");
		}
		
		return car;
	}
	
	@PostMapping("/cars")
	public ResponseEntity<Car> addCar(@Valid @RequestBody Car car){
		carService.saveOrUpdateCar(car);
		return new ResponseEntity<Car>(car, HttpStatus.CREATED);
	}
}
