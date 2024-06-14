package com.dojoninja.dojosandninjas.services;

import com.dojoninja.dojosandninjas.models.Dojo;
import com.dojoninja.dojosandninjas.repositories.DojoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DojoService {

    private final DojoRepository dojoRepository;

    @Autowired
    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }

    public List<Dojo> findAll() {
        return dojoRepository.findAll();
    }

    public Optional<Dojo> findById(Long id) {
        return dojoRepository.findById(id);
    }

    public void save(Dojo dojo) {
        dojoRepository.save(dojo);
    }

    // Additional methods as needed
}
