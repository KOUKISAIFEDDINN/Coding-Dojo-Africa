package com.dojoandninjas.testdojoandninjas.repository;

import com.dojoandninjas.testdojoandninjas.model.Ninja;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NinjasRepository extends CrudRepository<Ninja, Long> {
    List<Ninja> findAll();
}
