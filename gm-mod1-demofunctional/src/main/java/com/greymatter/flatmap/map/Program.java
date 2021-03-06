package com.greymatter.flatmap.map;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Program {
	
	public static void main(String[] args) {
		List<Persona> personas = new ArrayList<>();
		
		personas.add(new Persona("Pepe","Garica", LocalDate.of(1989, 12, 02)));
		personas.add(new Persona("Jorge","Medina", LocalDate.of(1989, 8, 12)));
		personas.add(new Persona("CARLOS","Nazario", LocalDate.of(1989, 07, 16)));
		personas.add(new Persona("augusto","Izecson", LocalDate.of(1989, 01, 18)));
		
		personas.stream()
				.map(p->p.getApellidos())
				.map(s->s.toUpperCase())
				.forEach(System.out::println);
		
		personas.stream()
				.map(p->p.getFechaNacimiento())
				.map(f->f.format(DateTimeFormatter.ofPattern("dd-MM")))
				.forEach(System.out::println);
		
				
		
	}
}
