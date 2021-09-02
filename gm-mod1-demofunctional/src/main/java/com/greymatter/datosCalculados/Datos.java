package com.greymatter.datosCalculados;

import java.util.Arrays;
import java.util.Random;

public class Datos {
	public static void main(String[] args) {
		double array[] = generarArrayAleatoria();
		System.out.println(Arrays.toString(array));
		
		double maximo = Arrays.stream(array)
							.max()
							.orElse(0);
		double minimo = Arrays.stream(array)
				.min()
				.orElse(0);		
		System.out.println(minimo);
		
		System.out.printf("El valor maximo es %.2f y minimo %.2f%n",maximo, minimo);
		
		double suma = Arrays.stream(array).sum();
		System.out.println("La suma de elementos es: " + suma);
				
	}
	
	public static double[] generarArrayAleatoria() {
		return new Random().doubles(100,0,1000).toArray();
	}	
}
