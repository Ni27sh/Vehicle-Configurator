package com.vca.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.vca.entity.Model;
import com.vca.repositories.ModelRepository;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    ModelRepository modelRepository;

    @Override
    public Page<Model> getAllModelsByManuIdAndSegId(Long manuId, Long segId, Pageable pageable) {
        return modelRepository.findByManufacturerIdAndSegmentId(manuId, segId, pageable);
    }
    
    @Override
    public Page<Model> getAllModels(Pageable pageable) {
        return modelRepository.findAllByOrderByCreatedAtDesc(pageable);
    }
    
    @Override
    public Model getModelsById(long id) {
        return modelRepository.findById(id).get();
    }
    
}
