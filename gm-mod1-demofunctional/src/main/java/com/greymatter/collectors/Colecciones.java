package com.greymatter.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Colecciones {
	public static void main(String[] args) {
		List<Empleado> empleados = Arrays.asList(
				new Empleado("jorge", 7000.00, "Compras"),
				new Empleado("henry", 5000.00, "Ventas"),
				new Empleado("juan", 4558.00, "Muertes"),
				new Empleado("pepe", 1288.00, "Operaciones"),
				new Empleado("jorge", 7000.00, "Compras")
				);
		
		Set<Empleado> empleadoSet = empleados.stream().collect(Collectors.toSet());
		System.out.println(empleadoSet);
		
		List<Empleado> empleadoList = empleados.stream().collect(Collectors.toList());
		System.out.println(empleadoList);
		
		Map<String, Double> empleadosMap = empleados.stream()
													.distinct()
													//.collect(Collectors.toMap(e->e.getNombre(), e->e.getSalario()));
													.collect(Collectors.toMap(Empleado::getNombre, Empleado::getSalario));
		
		System.out.println(empleadosMap);
	}			
}
