package com.inti.TD1_REST.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.inti.TD1_REST.model.Ecole;
import com.inti.TD1_REST.model.Etudiant;
import com.inti.TD1_REST.model.Professeur;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class ProfesseurRepositoryTests {

	@Autowired
	public ProfesseurRepository professeurRepository;
	
	Professeur p1;
	
	 @BeforeEach
		public void setUp()
		{
			p1 = new Professeur("Toto", "Titi", 2350);
		}
	 
	 @Test
		public void testGetAllStudents()
		{
			//GIVEN
			
			//WHEN
			List<Professeur> listeProfesseurs = professeurRepository.findAll();
			
			//THEN
			assertThat(listeProfesseurs).isNotEmpty();
			
			assertThat(listeProfesseurs).hasSize((int) professeurRepository.count());
		}
}
