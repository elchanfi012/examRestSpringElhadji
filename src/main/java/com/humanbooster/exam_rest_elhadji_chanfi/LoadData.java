package com.humanbooster.exam_rest_elhadji_chanfi;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.humanbooster.exam_rest_elhadji_chanfi.models.Car;
import com.humanbooster.exam_rest_elhadji_chanfi.models.Color;
import com.humanbooster.exam_rest_elhadji_chanfi.services.CarService;
import com.humanbooster.exam_rest_elhadji_chanfi.services.ColorService;



@Configuration
public class LoadData {

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(LoadData.class);
	
	@Bean
	public CommandLineRunner initDatabase(CarService carService, ColorService colorService) {
		
		if(carService.getNbCar() == 0) {
			
			log.info("Création de 2 voitures");
			
			List<Car> carsList = new ArrayList<Car>();
			
			carsList.add(new Car("peugeot", "308", "diesel", 2012, 172000, 6000, "peugeot 308 I 2L hdi 150"));
			carsList.add(new Car("peugeot", "208", "diesel", 2016, 12000, 10000, "peugeot 208 II 1.6L blueHdi 110"));
			
			log.info("Enregistrement de 2 voitures");
			carService.saveCars(carsList);
			
			
				
			log.info("Création de 2 couleurs");
			
			List<Color> colorsList = new ArrayList<Color>();
			colorsList.add(new Color("rgb(0,0,0)", "noir"));
			colorsList.add(new Color("rgb(255,114,0)", "jaune"));
			
			log.info("Enregistrement de 2 voitures");
			colorService.saveColors(colorsList);
				
				
			
			
			return (args) -> {
				for (Car car : carsList) {
					log.info("Enregistrement de " + car);
				}
				
				for (Color color: colorsList) {
					log.info("Enregistrement de " + color);
				}

			};
			
			
		}
		else {
			return (args) -> {
				
					log.info("Base de donnée déjà charger ");
				
			};
		}
	}
}
