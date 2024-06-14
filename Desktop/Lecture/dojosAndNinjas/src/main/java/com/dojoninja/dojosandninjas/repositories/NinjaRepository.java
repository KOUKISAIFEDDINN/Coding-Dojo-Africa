package com.dojoninja.dojosandninjas.repositories;


import com.dojoninja.dojosandninjas.models.Ninja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinjaRepository extends JpaRepository<Ninja, Long> {
    // Additional query methods can be added if needed
}
