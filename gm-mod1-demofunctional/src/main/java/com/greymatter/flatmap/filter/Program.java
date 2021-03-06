package com.greymatter.flatmap.filter;

import com.greymatter.flatmap.filter.Persona;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Program {
	public static void main(String[] args) {
		List<Persona> personas = Arrays.asList(new Persona("Jorge", LocalDate.of(1998, 2, 18)), 
												new Persona("Carlos", LocalDate.of(1989, 3, 22)),
												new Persona("Fiorella", LocalDate.of(1950, 4, 28)),
												new Persona("Rocio", LocalDate.of(1999, 5, 1)),
												new Persona("Augusto", LocalDate.of(2001, 6, 26)),
												new Persona("Julio", LocalDate.of(2002, 7, 29)),
												new Persona("Daniel", LocalDate.of(2000, 8, 19)),
												new Persona("Pepe", LocalDate.of(1979, 9, 14)));
		personas.stream()
				.filter(p->p.getEdad()>=18 && p.getEdad()<=65)
				.forEach(persona->System.out.printf("%s (%d a?os)%n", persona.getNombre(),persona.getEdad()));
	}
}
