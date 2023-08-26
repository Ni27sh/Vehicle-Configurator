package com.vca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.vca.entity.Component;
import com.vca.repositories.ComponentRepository;

@CrossOrigin(origins = "*")
@RestController
public class ComponentController {

	@Autowired
	ComponentRepository repository;

	@GetMapping("/components")
	public ResponseEntity<List<Component>> getAllComponentById() {
		List<Component> components = repository.findAll();

//	    if (components.isEmpty()) {
//	        throw new ResourceNotFoundException("No data found");
//	    }
	    
		return new ResponseEntity<>(components, HttpStatus.OK);
	}

}
