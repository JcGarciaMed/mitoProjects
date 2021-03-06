package com.greymatter.predicatefunction.predicate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Program {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			List<Persona> personas = new ArrayList<>();
			
			personas.add(new Persona("45555215","Pepe","PERES", LocalDate.of(1989, 07, 02)));
			personas.add(new Persona("45555223","Jorge","PERES", LocalDate.of(1989, 07, 02)));
			personas.add(new Persona("45555299","CARLOS","PERES", LocalDate.of(1989, 07, 02)));
			personas.add(new Persona("45555212","augusto","PERES", LocalDate.of(1989, 07, 02)));
			
			Predicate<Persona> predicateEdad = p->p.getEdad()>=35;
			Predicate<Persona> predicateApellidos = p->p.getApellidos().contains("e");
			Predicate<Persona> predicateCompuesto = predicateEdad.or(predicateApellidos);
			
			personas.stream()
					.filter(predicateCompuesto)
					.forEach(System.out::println); // referencia a metodos sin parámetros
	}
}
