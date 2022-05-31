package com.inti.TD1_REST.repository;

import java.util.List;

import com.inti.TD1_REST.model.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {


//	@Query("FROM Etudiant etu, Ecole eco WHERE etu.ecole_id=eco.id	AND eco.nom=NDA")
//	Etudiant findEtudiantInSchool();
	
	@Query(value = "select*from etudiant where ecole_id=:idEcole", nativeQuery = true)
	List<Etudiant> findByIdEcole (@Param("idEcole")int idEcole);
}
