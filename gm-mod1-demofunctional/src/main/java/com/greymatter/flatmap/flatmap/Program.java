package com.greymatter.flatmap.flatmap;

import java.util.Arrays;
import java.util.List;

public class Program {
	public static void main(String[] args) {
		List<Persona> personas = dataBase();
				
		personas.stream()
				.map(p->p.getViajes())
				.flatMap(v->v.stream())
				.map(v->v.getPais())
				.distinct()
				.forEach(System.out::println);		
	}
	public static List<Persona> dataBase(){
		Persona p1 = new Persona("Jorge");
		p1.getViajes().add(new Viaje("Espa?a"));
		p1.getViajes().add(new Viaje("italia"));
		p1.getViajes().add(new Viaje("francia"));
		
		Persona p2 = new Persona("Juan");
		p2.getViajes().add(new Viaje("Espa?a"));
		p2.getViajes().add(new Viaje("Alemania"));
		p2.getViajes().add(new Viaje("Inglaterra"));
		
		return Arrays.asList(p1, p2);
		
	}
}
