package com.inti.TD1_REST.repository;

import com.inti.TD1_REST.model.Ecole;
import com.inti.TD1_REST.model.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EcoleRepository extends JpaRepository<Ecole, Integer> {

	@Query("FROM Etudiant etu, Ecole eco WHERE etu.ecole_id=eco.id	AND eco.nom=NDA")
	Etudiant findEtudiantInSchool();
	
	@Query("From etudiant etu, ecole eco WHERE etu.ecole_id = eco.id AND ville=RBX")
	Etudiant findEtudiantFromRBX();
}
