package com.inti.TD1_REST.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor @AllArgsConstructor
public class Etudiant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom; 
	private String email; 
	private String telephone; 
	private String anneeEtude;
	
	@ManyToOne
	@JsonIgnore
	//@JoinColumn(name = "idEcole")
	private Ecole ecole;
	
	@ManyToMany
    @JoinTable(name="Prof_Etudiants",
	joinColumns = @JoinColumn(name="idEtu"),
	inverseJoinColumns = @JoinColumn(name="idProf"))
    private List<Professeur> listeProf;
	
	public Etudiant(String nom, String prenom, String email, String telephone, String anneeEtude) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.anneeEtude = anneeEtude;
	}

	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", telephone="
				+ telephone + ", anneeEtude=" + anneeEtude + ", ecole=" + ecole + "]";
	}
	
	 
}
