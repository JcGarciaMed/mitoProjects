package com.example.apirest1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.apirest1.entities.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
	@Query(value="select * from fn_listarResumen()", nativeQuery = true)
	List<Object[]> listarResumen(); 
}
