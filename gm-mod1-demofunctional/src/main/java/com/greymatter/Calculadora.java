package com.greymatter;

@FunctionalInterface
public interface Calculadora {
	int operacion(int a, int b); // s?lo un metodo abstracto --> functional // test upload
	default void saludo() {
		System.out.println("Hola mundo anonimo");
	}
	default int multi(int a, int b) {
		return a*b;
	}
}
