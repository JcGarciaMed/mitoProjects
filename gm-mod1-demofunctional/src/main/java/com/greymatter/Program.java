package com.greymatter;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculadora calculadora = new Calculadora() {
			
			@Override
			public int operacion(int a, int b) {
				// TODO Auto-generated method stub
				return a +b;
			}
		};
		System.out.println("Calculo clase Anonima " + calculadora.operacion(5, 2));
		
		Calculadora calculadora2 =(a,b)->a-b;
		System.out.println("Calculo clase Anonima " + calculadora2.operacion(5, 2));
		System.out.println("Multi clase Anonima " + calculadora2.multi(5, 2));
		calculadora2.saludo();		
	}

}
