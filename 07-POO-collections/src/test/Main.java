package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import ordenacao.Conta;

public class Main {

	public static void main(String[] args) {
		Collection<Conta> c = new ArrayList();
		
		c.add(new Conta("123", 50));
			
		List<String> palavras = new ArrayList<String>();
		
		palavras.add("Beber");
		palavras.add("Casar");
		palavras.add("Andar");
		
		palavras.forEach(System.out::println);
		
		Collections.sort(palavras);
		
		System.out.println("Lista ordenada:");
		
		palavras.forEach(System.out::println);
		
		
		List<String> lista = new ArrayList<String>();
		lista.add("A");
		lista.add("A");
		lista.add("B");
		lista.add("B");
		lista.add("C");
		lista.add("C");
		
		System.out.println("Lista:");
		lista.forEach(System.out::println);
		
		Set<String> set = new HashSet<String>();
		set.add("A");
		set.add("A");
		set.add("B");
		set.add("B");
		set.add("C");
		set.add("C");

		System.out.println("Set:");
		set.forEach(System.out::println);
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
