package com.inti.TD1_REST.repository;

import com.inti.TD1_REST.model.Ecole;
import com.inti.TD1_REST.model.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EcoleRepository extends JpaRepository<Ecole, Integer> 
{
	@Query(value = "select eco.* from etudiant etu, ecole eco where etu.ecole_id = eco.id and etu.email=:mail", nativeQuery = true)
			Ecole findSchoolByEmail(@Param("mail")String mail);
	
	@Query(value = "select eco.*from etudiant etu, ecole eco where etu.ecole_id=eco.id and etu.nom=:nom and etu.prenom=:prenom", nativeQuery = true)
	Ecole findSchoolByStudentName(@Param("nom")String nom, @Param("prenom")String prenom);
	
}
