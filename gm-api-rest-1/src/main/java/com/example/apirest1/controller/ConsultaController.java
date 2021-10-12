package com.example.apirest1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apirest1.dto.ConsultaListaExamen;
import com.example.apirest1.dto.ConsultaResumen;
import com.example.apirest1.entities.Consulta;
import com.example.apirest1.service.ConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
	
	@Autowired
	private ConsultaService consultaService;
	
	@PostMapping
	public ResponseEntity<Consulta> registrar(@RequestBody ConsultaListaExamen consultaExamenes){
		Consulta consulta = consultaService.registrarTransaccional(consultaExamenes);
		return new ResponseEntity<Consulta>(consulta,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ConsultaResumen>> listarResumen(){
		List<ConsultaResumen> reporte = consultaService.listarResumen();
		return new ResponseEntity<List<ConsultaResumen>>(reporte,HttpStatus.CREATED);
	}
	
	
	
	
}
