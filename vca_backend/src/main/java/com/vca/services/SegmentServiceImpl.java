package com.vca.services;

import com.vca.entity.Segment;
import com.vca.repositories.SegmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SegmentServiceImpl implements SegmentService {

	@Autowired
	SegmentRepository segmentRepository;

	@Override
	public List<Segment> getAllSegments() {
		return segmentRepository.findAll();
	}
}
