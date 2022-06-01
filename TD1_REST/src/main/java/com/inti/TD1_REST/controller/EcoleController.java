package com.inti.TD1_REST.controller;

import java.util.List;

import com.inti.TD1_REST.model.Ecole;
import com.inti.TD1_REST.model.Etudiant;
import com.inti.TD1_REST.repository.EcoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EcoleController {
	
	@Autowired
	EcoleRepository ecoleRepository;
	
	@GetMapping("/schools")
	public ResponseEntity<List<Ecole>> getAllSchools()
	{
		return new ResponseEntity<List<Ecole>>(ecoleRepository.findAll(), HttpStatus.OK);
		
	}
	
	@PostMapping("/saveEcole")
	public ResponseEntity<Ecole> saveEcole(@RequestBody Ecole ecole) 
	{   
	
		return new ResponseEntity<Ecole>(ecoleRepository.save(ecole), HttpStatus.CREATED);
	}
	
	@PutMapping("/updateEcole/{id}")
	public String updateEcole(@RequestBody Ecole ecole, @PathVariable int id)
	{
	//	Ecole e1 = ecoleRepository.getById(id);
	
		
		ecoleRepository.save(ecole);
		return "The student" + ecole + "has been updated"; 
		
	}
	
	@DeleteMapping("/deleteEcole")
	public String deleteEcole(@RequestParam("id") int id) 
	{
	
	ecoleRepository.deleteById(id);
	return "Ecole deleted";
	
	}

	
	@GetMapping("/SchoolByEmail/{email}")
	public Ecole getSchoolByEmail(@PathVariable String email)
	{
		return ecoleRepository.findSchoolByEmail(email);
	}
	
	@GetMapping("/SchoolByStudentName/{nom}/{prenom}")
	public Ecole getSchoolStudentName(@PathVariable String nom, @PathVariable String prenom)
	{
		return ecoleRepository.findSchoolByStudentName(nom, prenom);
	}
	
	
	
}
