package com.greymatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Stream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
		System.out.println("Lista de numeros original: " + numbers);	
		System.out.println("Lista de numeros filtrado: " + filterAllNumbersGreaterThan5AndDividedBy2(numbers));
		System.out.println("Lista de numeros multiplicado: " + multiplyElementBy2(numbers));
	}
	
	public static List<Integer> filterAllNumbersGreaterThan5AndDividedBy2(List<Integer> originals){
		/*List<Integer> numbers = new ArrayList<>();
		for (Integer integer : numbers) {
			if (integer>5 && integer%2==0) {
				numbers.add(integer);
			}
		}
		return numbers;*/
		Predicate<Integer> greterthan5= number->number>5;
		
		List<Integer> result = originals.stream()
							.filter(original->original>5)
							.filter(original->original%2==0)
							.collect(Collectors.toList());
		return result;
	}
	
	public static List<String> multiplyElementBy2(List<Integer> originals){
		List<String> result = originals.stream()
							.map(original->original*2)
							.map(original->"Coder" + String.valueOf(original))
							.collect(Collectors.toList());
		return result;
	}	
	
	

}
