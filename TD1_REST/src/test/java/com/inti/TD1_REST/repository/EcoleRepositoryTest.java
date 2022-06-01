package com.inti.TD1_REST.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.inti.TD1_REST.model.Ecole;
import com.inti.TD1_REST.model.Etudiant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class EcoleRepositoryTest {
	
	  @Autowired
	  EcoleRepository ecoleRepository;
	  
	  Ecole e1;
	  
	  @BeforeEach
		public void setUp()
		{
			e1 = new Ecole("Inti", "adresse", "cp", "ville");
		}
		@Test
		public void testGetSchoolByStudentName()
		{
			//GIVEN
			        
			//WHEN
			Ecole ecole = ecoleRepository.findSchoolByStudentName("marc","paté");
			
			//THEN
			assertThat(ecole).isNotNull();
			//assertThat(listeEtudiant).hasSize((int) etudiantRepository.count());
			assertThat(ecole.getNom()).isEqualTo("LC");
		}

}
