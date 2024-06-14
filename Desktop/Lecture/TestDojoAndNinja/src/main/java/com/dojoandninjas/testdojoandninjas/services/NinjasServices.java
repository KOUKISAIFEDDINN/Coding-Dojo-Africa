package com.dojoandninjas.testdojoandninjas.services;

import com.dojoandninjas.testdojoandninjas.model.Ninja;
import com.dojoandninjas.testdojoandninjas.repository.NinjasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NinjasServices {
    @Autowired
    private NinjasRepository ninjasRepository;

    public List<Ninja> allNinjas(){
        return ninjasRepository.findAll();
    }
    public Ninja createNinja(Ninja n){
        return ninjasRepository.save(n);
    }

    public Ninja findOneNinja(Long id){
        Optional<Ninja> oneNinja = ninjasRepository.findById(id);
        return oneNinja.orElse(null);
    }

    public Ninja updateNinja(Ninja n ){
        return ninjasRepository.save(n);
    }

    public void deleteOneNinja(Long id){
        ninjasRepository.deleteById(id);
    }

}
