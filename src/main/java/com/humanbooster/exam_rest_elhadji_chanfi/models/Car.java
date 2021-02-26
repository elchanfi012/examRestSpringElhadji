package com.humanbooster.exam_rest_elhadji_chanfi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "car")
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
    private Long id;
	
	@Column(name = "marque", nullable = false, length = 100)
    @NotNull(message = "la marque ne doit pas être nulle")
    @NotBlank(message = "la marque ne doit pas être vide")
    private String marque;
	
	@Column(name = "modele", nullable = false, length = 100)
    @NotNull(message = "le modèle ne doit pas être nul")
    @NotBlank(message = "le modèle ne doit pas être vide")
    private String modele;
	
	@Column(name = "carburant", nullable = false, length = 100)
    @NotNull(message = "le carburant ne doit pas être nul")
    @NotBlank(message = "le carburant ne doit pas être vide")
    private String carburant;
	
	@Column(name = "annee", nullable = false)
	@NotNull(message = "l' année ne doit pas être nulle")
    private Integer annee;

	@Column(name = "kilometrage", nullable = false)
	@NotNull(message = "le kilométrage ne doit pas être nul")
    private Integer kilometrage;
	
	@Column(name = "prix", nullable = false)
	@NotNull(message = "le prix ne doit pas être nul")
    private Integer prix;
	
	@Column(name = "description", nullable = false)
	@Type(type = "text")
    @NotNull(message = "la description ne doit pas être nulle")
    @NotBlank(message = "la description ne doit pas être vide")
    private String description;

	public Car(Long id,
			@NotNull(message = "la marque ne doit pas être nulle") @NotBlank(message = "la marque ne doit pas être vide") String marque,
			@NotNull(message = "le modèle ne doit pas être nul") @NotBlank(message = "le modèle ne doit pas être vide") String modele,
			@NotNull(message = "le carburant ne doit pas être nul") @NotBlank(message = "le carburant ne doit pas être vide") String carburant,
			@NotNull(message = "l' année ne doit pas être nulle") Integer annee,
			@NotNull(message = "le kilométrage ne doit pas être nul") Integer kilometrage,
			@NotNull(message = "le prix ne doit pas être nul") Integer prix,
			@NotNull(message = "la description ne doit pas être nulle") @NotBlank(message = "la description ne doit pas être vide") String description) {
		this.id = id;
		this.marque = marque;
		this.modele = modele;
		this.carburant = carburant;
		this.annee = annee;
		this.kilometrage = kilometrage;
		this.prix = prix;
		this.description = description;
	}

	public Car(
			@NotNull(message = "la marque ne doit pas être nulle") @NotBlank(message = "la marque ne doit pas être vide") String marque,
			@NotNull(message = "le modèle ne doit pas être nul") @NotBlank(message = "le modèle ne doit pas être vide") String modele,
			@NotNull(message = "le carburant ne doit pas être nul") @NotBlank(message = "le carburant ne doit pas être vide") String carburant,
			@NotNull(message = "l' année ne doit pas être nulle") Integer annee,
			@NotNull(message = "le kilométrage ne doit pas être nul") Integer kilometrage,
			@NotNull(message = "le prix ne doit pas être nul") Integer prix,
			@NotNull(message = "la description ne doit pas être nulle") @NotBlank(message = "la description ne doit pas être vide") String description) {
		this.marque = marque;
		this.modele = modele;
		this.carburant = carburant;
		this.annee = annee;
		this.kilometrage = kilometrage;
		this.prix = prix;
		this.description = description;
	}
	
	public Car() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getCarburant() {
		return carburant;
	}

	public void setCarburant(String carburant) {
		this.carburant = carburant;
	}

	public Integer getAnnee() {
		return annee;
	}

	public void setAnnee(Integer annee) {
		this.annee = annee;
	}

	public Integer getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(Integer kilometrage) {
		this.kilometrage = kilometrage;
	}

	public Integer getPrix() {
		return prix;
	}

	public void setPrix(Integer prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
