package com.inti.TD1_REST.controller;

import java.util.List;

import com.inti.TD1_REST.model.Etudiant;
import com.inti.TD1_REST.model.Utilisateur;
import com.inti.TD1_REST.repository.EtudiantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public ResponseEntity<List<Etudiant>> getAllEtudiants()
	{
		return new ResponseEntity<List<Etudiant>>(etudiantRepository.findAll(), HttpStatus.OK);
		
	}
	
	@PostMapping("/saveEtu")
	public ResponseEntity<Etudiant> saveEtudiant(@RequestBody Etudiant etudiant) 
	{
	
		return new ResponseEntity<Etudiant>(etudiantRepository.save(etudiant), HttpStatus.CREATED);
	}
	
	@PutMapping("/updateEtu/{id}")
	public String updateStudent(@RequestBody Etudiant etudiant, @PathVariable int id)
	{
		Etudiant e1 = etudiantRepository.getReferenceById(id);
	
		
		if (!e1.getNom().equals(etudiant.getNom()))
		{
			e1.setNom(etudiant.getNom());
		}
		
		if (!e1.getPrenom().equals(etudiant.getPrenom()) && etudiant.getPrenom() != null)
		{
			e1.setPrenom(etudiant.getPrenom());
		}
		
		
		etudiantRepository.save(e1);
		return "The student" + etudiant + "has been updated"; 
		
	}
	
	@DeleteMapping("/deleteEtu")
	public String deleteStudent(@RequestParam("id") int id) 
	{
	
	etudiantRepository.deleteById(id);
	return "Student deleted";
	
	}
}
