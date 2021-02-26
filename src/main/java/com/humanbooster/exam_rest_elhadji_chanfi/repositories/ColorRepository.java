package com.humanbooster.exam_rest_elhadji_chanfi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.humanbooster.exam_rest_elhadji_chanfi.models.Color;

public interface ColorRepository extends CrudRepository<Color, Long>{
	
	List<Color> findAll();
}
