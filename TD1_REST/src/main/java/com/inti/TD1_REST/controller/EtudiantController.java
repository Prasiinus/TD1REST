package com.inti.TD1_REST.controller;

import java.util.List;

import com.inti.TD1_REST.model.Etudiant;
import com.inti.TD1_REST.model.Utilisateur;
import com.inti.TD1_REST.repository.EtudiantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EtudiantController 
{
	@Autowired
	EtudiantRepository etudiantRepository;

	@GetMapping("/test")
	public String test()
	{
		
		return "Hello World!";
	}
	
	@GetMapping("/etudiants")
	public List<Etudiant> getAllEtudiants()
	{
		return etudiantRepository.findAll();
	}
	
	@PostMapping("/saveEtu")
	public String saveEtudiants()
	{
		Etudiant e = new Etudiant("jean", "claude");
		etudiantRepository.save(e);
		
		return "etudiant saved";
		
	}
}
