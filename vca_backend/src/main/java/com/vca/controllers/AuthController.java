
package com.vca.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vca.entity.Registration;
import com.vca.services.RegistrationService;

import jakarta.validation.Valid;
import response.ResponseHandler;

@Validated
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
    private RegistrationService registrationService;

	@PostMapping("/login")
	public ResponseEntity<Object> Login( @RequestBody  Registration company, BindingResult bindingResult){
		
		try {
	        // Authenticate the user here and generate a JWT token upon successful login
	        // You should replace this with your actual authentication logic

	        // If authentication is successful, generate a JWT token
			// String jwtToken = generateJwtToken(loginRequest.getUsername()); // Replace with your token generation logic
			Registration existComp=registrationService.findByUsername(company.getEmail());
	    	if(existComp==null||!existComp.getPassword().equals(company.getPassword())) {
	    		return ResponseEntity.badRequest().body("Invalid Credential");
	    	}
	    		Map<String, Object> responseData = new HashMap<>();
	            responseData.put("status", "success");
	          //  responseData.put("token", jwtToken);
	            return ResponseEntity.status(HttpStatus.OK).body(responseData);
	       
		}catch(Exception e) {
			// Handle authentication failure
	        Map<String, Object> errorResponse = new HashMap<>();
	        errorResponse.put("status", "error");
	        errorResponse.put("message", "Authentication failed"); // Customize this message
			return ResponseHandler.apiResponse(e.getMessage(), HttpStatus.UNAUTHORIZED, null);
		}
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<Object> Register( @RequestBody @Valid Registration registretion, BindingResult bindingResult){
		try {
			
			// Implement your registration logic here
			if(registrationService.findByUsername(registretion.getEmail())!=null)
	    	{
				return ResponseHandler.apiResponse("username already exist", HttpStatus.BAD_REQUEST, null);
	    	}
			if (bindingResult.hasErrors()) {
				return ResponseHandler.apiResponse("Validation response", HttpStatus.OK, null);
	        }

		       registrationService.createRegistration(registretion);
			
			return ResponseHandler.apiResponse("Registration successful", HttpStatus.OK, null);
		}catch(Exception e) {
	        Map<String, Object> errorResponse = new HashMap<>();
	        errorResponse.put("message", "Authentication failed");
			return ResponseHandler.apiResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
		}
		
	}

}