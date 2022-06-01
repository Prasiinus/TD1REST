package com.inti.TD1_REST.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.inti.TD1_REST.Json;
import com.inti.TD1_REST.model.Etudiant;
import com.inti.TD1_REST.repository.EcoleRepository;
import com.inti.TD1_REST.repository.EtudiantRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;



@WebMvcTest(EtudiantController.class)
public class EtudiantControllerTest {  

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
			mockMvc.perform(get("/etudiants"))
				.andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	public void testSaveStudents()
	{
		try {
			
			mockMvc.perform(post("/saveEtu")
					.contentType(MediaType.APPLICATION_JSON)
					.content(Json.fromObject(new Etudiant("jo", "rick", "jr", "4848", "5"))))
					.andExpect(status().isCreated());
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	public void testGetAllStudentsInLyon()
	{
		try {
			mockMvc.perform(get("/etudiantsInLyon"))
				.andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}	 
	}


}
