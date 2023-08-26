package com.vca.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vca.entity.Manufacturer;
import com.vca.repositories.ManufacturerRepository;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

	@Autowired
	ManufacturerRepository manufacturerRepository;

	@Override
	public List<Manufacturer> getAllManufacturersById(Long segId) {
		return manufacturerRepository.findBySegmentId(segId);
	}

}


