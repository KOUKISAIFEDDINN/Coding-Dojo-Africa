package com.dojoandninjas.testdojoandninjas.repository;


import com.dojoandninjas.testdojoandninjas.model.Dojo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DojosRepository extends CrudRepository<Dojo, Long> {

    List<Dojo> findAll();
}
