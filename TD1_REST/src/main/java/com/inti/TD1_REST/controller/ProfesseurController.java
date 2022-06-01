package com.inti.TD1_REST.controller;

import java.util.List;

import com.inti.TD1_REST.model.Ecole;
import com.inti.TD1_REST.model.Professeur;

import com.inti.TD1_REST.repository.ProfesseurRepository;

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
public class ProfesseurController {

	@Autowired
	ProfesseurRepository professeurRepository;
	
	@GetMapping("/Profs")
	public ResponseEntity<List<Professeur>> getAllProfs()
	{
		return new ResponseEntity<List<Professeur>>(professeurRepository.findAll(), HttpStatus.OK);
		
	}
	
	@PostMapping("/saveProf")
	public ResponseEntity<Professeur> saveProf(@RequestBody Professeur prof) 
	{
	
		return new ResponseEntity<Professeur>(professeurRepository.save(prof), HttpStatus.CREATED);
	}
	
	@PutMapping("/updateProf/{id}")
	public String updateProf(@RequestBody Professeur prof, @PathVariable int id)
	{
	//	Ecole e1 = ecoleRepository.getById(id);
	
		
		professeurRepository.save(prof);
		return "The student" + prof + "has been updated"; 
		
	}
	
	@DeleteMapping("/deleteProf")
	public String deleteProf(@RequestParam("id") int id) 
	{
	
	professeurRepository.deleteById(id);
	return "prof deleted";
	 
	}
	
	@GetMapping("/sortSalaireProfBySchool/{id}")
	public List<Professeur> getSortSalaireProfBySchool(@PathVariable int id)
	{
		return professeurRepository.sortSalaireProfBySchool(id);
	}
}
