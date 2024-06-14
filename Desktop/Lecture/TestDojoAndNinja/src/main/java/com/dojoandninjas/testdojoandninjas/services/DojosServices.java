package com.dojoandninjas.testdojoandninjas.services;


import com.dojoandninjas.testdojoandninjas.model.Dojo;
import com.dojoandninjas.testdojoandninjas.repository.DojosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DojosServices {
    @Autowired
    private DojosRepository dojosRepository;


    public List<Dojo> allDojos(){
        return dojosRepository.findAll();
    }


    public Dojo createDojo(Dojo d){
        return dojosRepository.save(d);
    }


    public Dojo findOneDojoById(Long id){
        Optional<Dojo> maybeDojos = dojosRepository.findById(id);
        return maybeDojos.orElse(null);
    }

    public Dojo updateDojos(Dojo d){
        return dojosRepository.save(d);
    }


    public void deleteDojos(Long id){
        dojosRepository.deleteById(id);
    }



}
