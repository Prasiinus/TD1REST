package com.inti.TD1_REST.repository;

import com.inti.TD1_REST.model.Ecole;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcoleRepository extends JpaRepository<Ecole, Integer> {

}
