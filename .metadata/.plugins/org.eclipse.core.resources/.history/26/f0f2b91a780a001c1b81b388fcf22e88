package com.greymatter.predicatefunction.function;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.greymatter.predicatefunction.predicate.Persona;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona("45555215","Pepe","PERES", LocalDate.of(1989, 07, 02)));
		personas.add(new Persona("45555223","Jorge","PERES", LocalDate.of(1989, 07, 02)));
		personas.add(new Persona("45555299","CARLOS","PERES", LocalDate.of(1989, 07, 02)));
		personas.add(new Persona("45555212","augusto","PERES", LocalDate.of(1989, 07, 02)));
		
		personas.stream()
				.map(p->p.getApellidos())
				.forEach(System.out::println);
	}

}
