package com.greymatter.predicatefunction.function;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.greymatter.predicatefunction.predicate.Persona;

import lombok.var;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Persona> personas = new ArrayList<>();
			
		personas.add(new Persona("45555215","Pepe","Garcia", LocalDate.of(1989, 07, 02)));
		personas.add(new Persona("45555223","Jorge","Medina", LocalDate.of(1989, 07, 02)));
		personas.add(new Persona("45555299","CARLOS","Rivera", LocalDate.of(1989, 07, 02)));
		personas.add(new Persona("45555212","augusto","Calderon", LocalDate.of(1989, 07, 02)));
		
		personas.stream() // Stream<Persona>
				.map(p->p.getApellidos())// Stream<String>
				.forEach(System.out::println);		
		
		Function<Persona, String> functionPersonaANombres=(p->p.getNombre());
		transformarEmpleadosEnNombres(personas, functionPersonaANombres).forEach(System.out::println);
	}
	
	private static List<String> transformarEmpleadosEnNombres(List<Persona> personas, Function<Persona, String> functionPersona){
		List<String> result = new ArrayList<>();
		for (Persona per : personas) {
			result.add(functionPersona.apply(per));
		}
		return result;
	}

}
