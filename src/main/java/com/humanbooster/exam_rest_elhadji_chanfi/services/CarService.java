package com.humanbooster.exam_rest_elhadji_chanfi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanbooster.exam_rest_elhadji_chanfi.models.Car;
import com.humanbooster.exam_rest_elhadji_chanfi.repositories.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepository;
	
	public List<Car> getCars(){
		return carRepository.findAll();
	}
	
	public void saveOrUpdateCar(Car car) {
		carRepository.save(car);
	}
	
	public void deleteCar(Car car) {
		carRepository.delete(car);
	}
	
	public Long getNbCar() {
		return carRepository.count();
	}
	
	public void saveCars(List<Car> cars) {
		carRepository.saveAll(cars);
	}
}
