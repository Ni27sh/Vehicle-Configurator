package com.vca.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vca.entity.Segment;
import com.vca.services.SegmentService;

import response.ResponseHandler;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class SegmentController {

	@Autowired
	SegmentService segmentService;

	@GetMapping("/segments")
	public ResponseEntity<Object> getAllSegments() {
		try {
			List<Segment> data = segmentService.getAllSegments();
			return ResponseHandler.apiResponse("Segments retrieved successfully", HttpStatus.OK, data);

		} catch (Exception e) {
			return ResponseHandler.apiResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
		}
	}

}