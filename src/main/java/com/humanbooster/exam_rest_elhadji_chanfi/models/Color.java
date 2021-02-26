package com.humanbooster.exam_rest_elhadji_chanfi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "color")
public class Color {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
    private Long id;
	
	@Column(name = "code_rgb", nullable = false, length = 100)
    @NotNull(message = "le code rgb ne doit pas être nul")
    @NotBlank(message = "le code rgb ne doit pas être vide")
    private String codeRgb;
	
	@Column(name = "libelle", nullable = false, length = 100)
    @NotNull(message = "le libellé ne doit pas être nul")
    @NotBlank(message = "le libellé ne doit pas être vide")
    private String libelle;

	public Color(Long id,
			@NotNull(message = "le code rgb ne doit pas être nul") @NotBlank(message = "le code rgb ne doit pas être vide") String codeRgb,
			@NotNull(message = "le libellé ne doit pas être nul") @NotBlank(message = "le libellé ne doit pas être vide") String libelle) {
		this.id = id;
		this.codeRgb = codeRgb;
		this.libelle = libelle;
	}

	public Color(
			@NotNull(message = "le code rgb ne doit pas être nul") @NotBlank(message = "le code rgb ne doit pas être vide") String codeRgb,
			@NotNull(message = "le libellé ne doit pas être nul") @NotBlank(message = "le libellé ne doit pas être vide") String libelle) {
		this.codeRgb = codeRgb;
		this.libelle = libelle;
	}

	public Color() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodeRgb() {
		return codeRgb;
	}

	public void setCodeRgb(String codeRgb) {
		this.codeRgb = codeRgb;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
