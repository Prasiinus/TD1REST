package com.inti.TD1_REST.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@NoArgsConstructor  @AllArgsConstructor
public class Ecole { 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom; 
	private String adresse;
	private String cp;
	private String ville;
	
	 @OneToMany(mappedBy = "ecole")
	@JsonIgnore
	 private List<Etudiant> listeEtudiant;
	 
	 @ManyToMany
	    @JoinTable(name="Prof_Ecole",
		joinColumns = @JoinColumn(name="idEcole"),
		inverseJoinColumns = @JoinColumn(name="idProf"))
		@JsonIgnore
	    private List<Professeur> listeProf;

	public Ecole(String nom, String adresse, String cp, String ville) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Ecole [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", cp=" + cp + ", ville=" + ville + "]";
	}
	 
	 
}
