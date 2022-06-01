package com.inti.TD1_REST.repository;

import java.util.List;

import com.inti.TD1_REST.model.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

	@Query(value = "select*from etudiant where ecole_id=:idEcole", nativeQuery = true)
	List<Etudiant> findByIdEcole (@Param("idEcole")int idEcole);
	
	@Query(value = "select * from etudiant where ecole_id in (\n"
			+ "select id from ecole where ville=\"RBX\");", nativeQuery = true)
	List<Etudiant> findByVille ();
}
