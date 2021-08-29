package com.greymatter.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.greymatter.entities.Company;
import com.greymatter.entities.Individual;
import com.greymatter.entities.TaxPayer;

public class Program {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		List<TaxPayer> taxPayers=new ArrayList<>();
				
		System.out.println("Ingrese el numero de contribuyentes");
		int numberOfTaxPayers=sc.nextInt();
		
		for (int i = 1; i <= numberOfTaxPayers; i++) {
			System.out.println("Contribuyente "+i+" :");
			System.out.println("Individual o Company (i/c)?");
			char typeTaxPayer=sc.next().charAt(0);
			System.out.println("Nombre:");
			String name=sc.next();
			System.out.println("Gasto anual:");
			Double anualIncome=sc.nextDouble();
			
			if(typeTaxPayer=='i') {
				System.out.println("Gastos de salud:");
				Double healthExpenditures=sc.nextDouble();
				taxPayers.add(new Individual(name, anualIncome, healthExpenditures));
			}else {
				System.out.println("Numero de empleados:");
				int numberOfEmployees=sc.nextInt();
				taxPayers.add(new Company(name, anualIncome, numberOfEmployees));
			}
				
			System.out.println();
			System.out.println("Contribuyentes");
			for (TaxPayer taxPayer : taxPayers) {
				System.out.println(taxPayer.getName()+": S/. "+String.format("%2.f", taxPayer.tax()));
			}
			
			System.out.println();
			double sum=0.0;
			for (TaxPayer taxPayer : taxPayers) {
				sum+=taxPayer.tax();
			}
			
			System.out.println("Total de impuestos: S/."+String.format("%2.f",sum));			
		}
	}
}
