package com.vca.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vca.services.AlternateComponentService;

import response.ResponseHandler;

@RestController
@CrossOrigin("*")
public class AlternateComponentController {

	@Autowired
	AlternateComponentService service;

	@GetMapping(value = "api/alternate_components/{modId}/{compId}")
	public ResponseEntity<Object> showStdComponents(@PathVariable(value = "modId") int mod_id,
			@PathVariable(value = "compId") int com_id) {
		List<?> data = service.findByModelIdAndCompId(mod_id, com_id);
		return ResponseHandler.apiResponse("Models retrieved successfully", HttpStatus.OK, data);
		// return service.findByModelIdAndCompId(mod_id, com_id);
	}

}