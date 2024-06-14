package com.dojoninja.dojosandninjas.repositories;


import com.dojoninja.dojosandninjas.models.Dojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DojoRepository extends JpaRepository<Dojo, Long> {
}
