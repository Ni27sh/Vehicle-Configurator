package com.vca.services;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.vca.entity.Segment;

public interface SegmentService {
    List<Segment> getAllSegments();
}

