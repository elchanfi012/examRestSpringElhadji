package com.humanbooster.exam_rest_elhadji_chanfi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanbooster.exam_rest_elhadji_chanfi.models.Color;
import com.humanbooster.exam_rest_elhadji_chanfi.repositories.ColorRepository;

@Service
public class ColorService {

	@Autowired
	private ColorRepository colorRepository;
	
	public List<Color> getColors() {
		return colorRepository.findAll();
	}
	
	public void saveOrUpdateColor(Color color) {
		colorRepository.save(color);
	}
	
	public void deleteColor(Color color) {
		colorRepository.delete(color);
	}
	
	public Long getNbColor() {
		return colorRepository.count();
	}
	
	public void saveColors(List<Color> colors){
		colorRepository.saveAll(colors);
	}
}
