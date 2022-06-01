package com.inti.TD1_REST.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.inti.TD1_REST.repository.EcoleRepository;
import com.inti.TD1_REST.repository.EtudiantRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(EcoleController.class)
public class EcoleControllerTest {

	@Autowired
	private MockMvc mockMvc;
	

	@MockBean
	private EtudiantRepository etudiantRepository;
	
	@MockBean
	private EcoleRepository ecoleRepository;
	
	@Test
	public void testGetAllStudents()
	{
		try {
			mockMvc.perform(get("/SchoolByStudentName/{nom}/{prenom}", "marc", "paté"))
				.andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
}
