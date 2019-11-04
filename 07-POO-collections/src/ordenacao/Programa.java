package ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Programa {

	public static void main(String[] args) {
		Conta c1 = new Conta("789", 10);
		Conta c2 = new Conta("123", 80);
		Conta c3 = new Conta("456", 70);
		
		List<Conta> lista = new ArrayList<>();
		lista.add(c1);
		lista.add(c2);
		lista.add(c3);
		
		imprimirContas(lista);
		
		
		System.out.println("\nContas ordenadas pelo numero:");
		Collections.sort(lista);
		imprimirContas(lista);
		
		System.out.println("\nContas ordenadas pelo saldo:");
		Comparator comparadorContaPorSaldo = new ComparadorContaPorSaldo();
		Collections.sort(lista, comparadorContaPorSaldo);
		imprimirContas(lista);
		
		Map<String, Conta> mapContas = new HashMap(); 
		
		mapContas.put(c1.getNumero(), c1);
		mapContas.put(c2.getNumero(), c2);
		mapContas.put(c3.getNumero(), c3);
		
		Conta c = mapContas.get("456");
		System.out.println("Conta 456: " + c);
		
	}

	private static void imprimirContas(List<Conta> lista) {
		for (Conta conta : lista) {
			System.out.println("Conta: " + conta);
		}
	}

}
