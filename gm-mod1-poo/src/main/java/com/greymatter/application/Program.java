package com.greymatter.application;
import java.time.LocalDate;
import java.util.Scanner;

import com.greymatter.entities.Client;
import com.greymatter.entities.Order;
import com.greymatter.entities.OrderItem;
import com.greymatter.entities.Product;
import com.greymatter.entities.enums.OrderStatus;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter client data");
		System.out.print("Name:");
		String name=sc.nextLine();
		System.out.print("Email");
		String email=sc.next();
		System.out.print("Birth date:");
		String birthDateString =sc.next();
		LocalDate birthDate=LocalDate.parse(birthDateString);
		
		
		Client client=new Client(name, email, birthDate);
		
		System.out.print("Enter order data:");
		System.out.print("Status:");
		
		OrderStatus status=OrderStatus.valueOf(sc.next());
		
		Order order=new Order(LocalDate.now(), status, client);
		
		System.out.print("How many items to this order?:");
		int numberOfItems=sc.nextInt();
		
		for (int i = 1; i <= numberOfItems; i++) {
			System.out.println("Enter nro "+i+" item data");
			System.out.print("Product name:");
			sc.nextLine();
			String productName=sc.nextLine();
			
			System.out.print("Product price:");
			double productPrice=sc.nextDouble();
			
			System.out.print("Quantity:");
			int quantity=sc.nextInt();
			
			Product product=new Product(productName, productPrice);
			
			OrderItem orderItem=new OrderItem(quantity, productPrice, product);
			
			//order.getItems().add(orderItem);
			
			order.addItem(orderItem);		
		}
		
		System.out.println();
		System.out.println(order);
		
		sc.close();
		
	}

}
