package com.example.apirest1.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="examen")
public class Examen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer idExamen;
	
	@Column(name="nombre", nullable=false, length=50)
	private String nombre;
	
	@Column(name="description", nullable=false, length=150)
	private String description;
	

	public Integer getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(Integer idExamen) {
		this.idExamen = idExamen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
