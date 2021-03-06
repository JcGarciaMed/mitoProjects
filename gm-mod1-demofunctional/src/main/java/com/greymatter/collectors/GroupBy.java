package com.greymatter.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class GroupBy {
	public static void main(String[] args) {
		List<Empleado> empleados = Arrays.asList(
				new Empleado("jorge", 7000.00, "Compras"),
				new Empleado("henry", 5000.00, "Ventas"),
				new Empleado("juan", 4558.00, "Muertes"),
				new Empleado("pepe", 1288.00, "Operaciones"),
				new Empleado("Coco", 7000.00, "Compras")
				);
		Map<String, List<Empleado>> porDepartamento = empleados.stream().collect(groupingBy(Empleado::getDepartamento));
		System.out.println(porDepartamento);
		
		porDepartamento.forEach((k,v)->{
			String nombres = v.stream().map(Empleado::getNombre).collect(joining(","));
			System.out.printf("Departamento: %s | Empleados:%s %n", k, nombres);
			});
	}
}
