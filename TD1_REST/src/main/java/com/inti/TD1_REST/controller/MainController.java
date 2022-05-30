package com.inti.TD1_REST.controller;

import java.util.ArrayList;
import java.util.List;

import com.inti.TD1_REST.model.Ecole;
import com.inti.TD1_REST.model.Etudiant;
import com.inti.TD1_REST.model.Professeur;
import com.inti.TD1_REST.model.Utilisateur;
import com.inti.TD1_REST.repository.EcoleRepository;
import com.inti.TD1_REST.repository.ProfesseurRepository;
import com.inti.TD1_REST.repository.UtilisateurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MainController 

{

	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	@Autowired
	EcoleRepository ecoleRepository;
	
	@Autowired
	ProfesseurRepository professeurRepository;
	
	
	@GetMapping("/hello")
	public String hello()
	{
		
		return "Hello World!";
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET) //on aurait pu utiliser getmapp 
	public List<Utilisateur> getAllUsers()
	{
		return utilisateurRepository.findAll();
	}
	
	@PostMapping("/save")
	public String saveUser()
	{
		Utilisateur u = new Utilisateur("login", "login");
		utilisateurRepository.save(u);
		
		return "user saved";
		
	}
	
	@PutMapping("/updateEcoleProf/{idProf}/{idEcole}")
	public String updateStudentAvecEcole(@PathVariable int idProf, @PathVariable int idEcole)
	{
		Ecole ecole = ecoleRepository.getReferenceById(idEcole);
		Professeur prof = professeurRepository.getReferenceById(idProf);
		
		List<Professeur> listProfesseurs = new ArrayList<Professeur>();
		
		listProfesseurs.add(prof);
	
		
		ecole.setListeProf(listProfesseurs);
		ecoleRepository.save(ecole);
		return "the school : " + ecole + "has been updated";
	
	}
	
}
