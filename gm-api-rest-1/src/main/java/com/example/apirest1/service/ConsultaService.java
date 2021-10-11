package com.example.apirest1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apirest1.dto.ConsultaListaExamen;
import com.example.apirest1.dto.ConsultaResumen;
import com.example.apirest1.entities.Consulta;
import com.example.apirest1.entities.ConsultaExamen;
import com.example.apirest1.repositories.ConsultaExamenRepository;
import com.example.apirest1.repositories.ConsultaRepository;

@Service
public class ConsultaService {
	
	@Autowired
	private  ConsultaRepository consultaRepository;
	@Autowired
	private ConsultaExamenRepository consultaExamenRepository;
	
	
	public Consulta registrarTransaccional(ConsultaListaExamen dto) {
		//Completa detalle de consulta
		dto.getConsulta().getDetalleConsultas().forEach(det->det.setConsulta(dto.getConsulta()));
		consultaRepository.save(dto.getConsulta());
		dto.getExamenes().forEach(ex->consultaExamenRepository.registrar(dto.getConsulta().getIdConsulta(), ex.getIdExamen()));
		return dto.getConsulta();
	}
	
	public List<ConsultaResumen> listarResumen(){
		List<ConsultaResumen> consultas = new ArrayList<>();
		consultaRepository.listarResumen()
							.forEach(x->{
								ConsultaResumen cr = new ConsultaResumen();
								cr.setCantidad(Integer.parseInt(String.valueOf(x[0])));
								cr.setFecha(String.valueOf(x[1]));
								consultas.add(cr);
							});
		return consultas;
	}
}
