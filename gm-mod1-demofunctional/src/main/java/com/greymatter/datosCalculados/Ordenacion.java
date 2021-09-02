package com.greymatter.datosCalculados;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Ordenacion {
	public static void main(String[] args) {
		int[] array=generarArrayAleatoria();
		System.out.println("Array sin ordenar");
		System.out.println(Arrays.toString(array));
		
		int[] ordenado = Arrays.stream(array)
							.sorted()
							.toArray();
		
		System.out.println("Array ordenado");
		System.out.println(Arrays.toString(ordenado));		
	
		List<String> ciudades = Arrays.asList("Jaen", "Córdoba", "Lima", "Chiclayo", "trujillo");
		ciudades.stream()
				.sorted((s1,s2)->-s1.compareTo(s2))
				.forEach(System.out::println);

	}
	
	public static int[] generarArrayAleatoria() {
		return new Random().ints(100,0,1000).toArray();
	}
}

