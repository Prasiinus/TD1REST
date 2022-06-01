package com.inti.TD1_REST.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.inti.TD1_REST.model.Etudiant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class EtudiantRepositoryTests 
{
	@Autowired
	EtudiantRepository etudiantRepository;

	Etudiant e1;
	
	@BeforeEach
	public void setUp()
	{
		e1 = new Etudiant("jo", "rick", "jr", "4848", "5");
	}
	@Test
	public void testSaveStudent()
	{
		//When 
		Etudiant etudiant = etudiantRepository.save(e1); 
		
		//Then
		assertThat(etudiant).isNotNull();
	}
	
	@Test
	public void testGetAllStudents()
	{
		//GIVEN
		
		//WHEN
		List<Etudiant> listeEtudiant = etudiantRepository.findAll();
		
		//THEN
		assertThat(listeEtudiant).isNotEmpty();
		assertThat(listeEtudiant).hasSize(6);
		assertThat(listeEtudiant).hasSize((int) etudiantRepository.count());
	}
	
	@Test
	public void testGetAllStudentsInLyon()
	{
		//GIVEN
		
		//WHEN
		List<Etudiant> listeEtudiant = etudiantRepository.findByVille();
		
		//THEN
		assertThat(listeEtudiant).isNotEmpty();
		//assertThat(listeEtudiant).hasSize((int) etudiantRepository.count());
		assertThat(listeEtudiant.get(0).getEcole().getVille()).isEqualTo("RBX");
	}
}
