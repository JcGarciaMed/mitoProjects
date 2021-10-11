package com.example.apirest1.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.apirest1.entities.ConsultaExamen;

@Repository
public interface ConsultaExamenRepository extends JpaRepository<ConsultaExamen, Integer>{
	
	@Modifying
	@Query(value="INSERT INTO consulta_examen(id_consulta,id_examen) VALUES(:idConsulta,:idExamen)", nativeQuery = true)
	Integer registrar(Integer idConsulta, Integer idExamen);
}
