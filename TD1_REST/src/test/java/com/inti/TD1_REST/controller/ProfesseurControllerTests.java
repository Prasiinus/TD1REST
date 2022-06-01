package com.inti.TD1_REST.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.inti.TD1_REST.repository.EcoleRepository;
import com.inti.TD1_REST.repository.EtudiantRepository;
import com.inti.TD1_REST.repository.ProfesseurRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ProfesseurController.class)
public class ProfesseurControllerTests {

	@Autowired
	private MockMvc mockMvc;
	

	@MockBean
	private EtudiantRepository etudiantRepository;
	
	@MockBean
	private EcoleRepository ecoleRepository;
	
	@MockBean
	private ProfesseurRepository professeurRepository;
	
	@Test
	public void testsortSalaireProfBySchool()
	{
		try {
			mockMvc.perform(get("/sortSalaireProfBySchool/{id}", "1"))
				.andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
