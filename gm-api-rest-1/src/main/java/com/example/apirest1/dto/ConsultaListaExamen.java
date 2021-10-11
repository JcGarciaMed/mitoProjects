package com.example.apirest1.dto;

import java.util.List;

import com.example.apirest1.entities.Consulta;
import com.example.apirest1.entities.Examen;

public class ConsultaListaExamen {
	private Consulta consulta;
	private List<Examen> examenes;
	
	public Consulta getConsulta() {
		return consulta;
	}
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}
	public List<Examen> getExamenes() {
		return examenes;
	}
	public void setExamenes(List<Examen> examenes) {
		this.examenes = examenes;
	}
	
	
}
