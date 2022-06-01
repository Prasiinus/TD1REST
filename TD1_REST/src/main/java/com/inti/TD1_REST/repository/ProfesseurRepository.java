package com.inti.TD1_REST.repository;


import java.util.List;

import com.inti.TD1_REST.model.Professeur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesseurRepository extends JpaRepository<Professeur, Integer> {

	@Query(value = "select p.* from professeur p, ecole e, professeur_ecole pe\r\n"
			+ "where p.id = pe.id_prof and e.id = pe.id_ecole and e.id =:id\r\n"
			+ "order by salaire;", nativeQuery = true)
	List<Professeur> sortSalaireProfBySchool(@Param("id")int id);
}
