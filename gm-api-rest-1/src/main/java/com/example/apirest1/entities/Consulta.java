package com.example.apirest1.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="consulta")
public class Consulta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer idConsulta;
	
	@ManyToOne
	@JoinColumn(name="id_paciente	", nullable = false, 
	foreignKey = @ForeignKey(name="FK_consulta_paciente"))	
	private Paciente paciente;
	
	@Column(name="num_Consultorio", nullable=false, length=3)
	private String numConsultorio;
	
	@Column(name="fecha", nullable=false)
	private LocalDateTime fecha;
	
	@OneToMany(mappedBy = "consulta", cascade = {CascadeType.ALL})
	private List<DetalleConsulta> detalleConsultas;

	public Integer getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getNumConsultorio() {
		return numConsultorio;
	}

	public void setNumConsultorio(String numConsultorio) {
		this.numConsultorio = numConsultorio;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public List<DetalleConsulta> getDetalleConsultas() {
		return detalleConsultas;
	}

	public void setDetalleConsultas(List<DetalleConsulta> detalleConsultas) {
		this.detalleConsultas = detalleConsultas;
	}
	
	
	
}
