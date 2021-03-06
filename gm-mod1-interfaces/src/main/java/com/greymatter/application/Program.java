package com.greymatter.application;

import com.greymatter.entities.Contract;
import com.greymatter.entities.Installment;
import com.greymatter.service.impl.PayPalService;
import com.greymatter.service.impl.ContractService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter contract data");
        System.out.print("Number: ");
        Integer number = sc.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        Date date = sdf.parse(sc.next());
        System.out.print("Contract value: ");
        Double totalValue = sc.nextDouble();

        Contract contract = new Contract(number, date, totalValue);

        System.out.print("Enter number of installments: ");
        int numberOfInstallments = sc.nextInt();

        ContractService cs = new ContractService(new PayPalService());

        cs.processContract(contract, numberOfInstallments);

        System.out.println("Installments:");
        for (Installment it : contract.getInstallments()) {
            System.out.println(it);
        }

        sc.close();		
		
	}

}
