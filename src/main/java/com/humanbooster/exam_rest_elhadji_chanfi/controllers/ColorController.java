package com.humanbooster.exam_rest_elhadji_chanfi.controllers;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.server.ResponseStatusException;

import com.humanbooster.exam_rest_elhadji_chanfi.models.Color;
import com.humanbooster.exam_rest_elhadji_chanfi.models.Response;
import com.humanbooster.exam_rest_elhadji_chanfi.services.ColorService;

@RestController
@RequestMapping("/api")
public class ColorController {

	@Autowired
	private ColorService colorService;
	
	@GetMapping("/colors")
	public List<Color> getColors(){
		return colorService.getColors();
	}
	
	@GetMapping("/colors/{color}")
	public Color getColorById(@PathVariable(name = "color", required = false) Color color) {
		if(color == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Color Not Found");
		}
		
		return color;
	}
	
	@PostMapping("/colors")
	public ResponseEntity<Color> addColor(@Valid @RequestBody Color color){
		
		colorService.saveOrUpdateColor(color);
		return new ResponseEntity<Color>(color, HttpStatus.CREATED);
	}
	
	@PutMapping("/colors/{color}")
	public ResponseEntity<Color> editColor(@PathVariable(name = "color", required = false) Color color,
			                               @Valid @RequestBody Color colorToUpdate){
		if(color == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Color Not Found");
		}
		
		colorToUpdate.setId(color.getId());
		colorService.saveOrUpdateColor(colorToUpdate);
		return new ResponseEntity<Color>(color, HttpStatus.OK);
	}
	
	@DeleteMapping("/colors/{color}")
	public ResponseEntity<Response> deleteColor(@PathVariable(name = "color", required = false) Color color) {
		if(color == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Color Not Found");
		}
		
		colorService.deleteColor(color);
		String body = "color successfully deleted";
	
		return new ResponseEntity<Response>(new Response(body), HttpStatus.OK);
	}
}
