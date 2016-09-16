package br.ufrpe.poo.programas;

import br.ufrpe.poo.beans.Conta;
import br.ufrpe.poo.repositorio.RepositorioConta;

public class ProgramaBanco {

	public static void main(String[] args) {

		// inicializa repositório com capacidade para 100 contas
		RepositorioConta banco = new RepositorioConta(100);
		RepositorioConta banco2 = new RepositorioConta(500);
		
		String numero = new String("123");
		Conta c1 = new Conta("123", 500);
		Conta c2 = new Conta("345", 200);
		Conta c3 = new Conta("567", 700);
		Conta c4 = new Conta("890", 1000);
		Conta c5 = new Conta("567", 700);
		Conta c6 = new Conta("680", 1000);
		Conta c7 = new Conta("700", 700);
		Conta c8 = new Conta("800", 1000);
		
		banco.inserir(c1);
		banco.inserir(c2);
		banco.inserir(c3);
		banco.inserir(c4);
		banco.inserir(c5);

		
		System.out.println("Conta 123: " + banco.buscar("123"));
		banco.remover("123");
		banco.remover("890");
		banco.inserir(new Conta());
		System.out.println("Conta 123: " + banco.buscar("123"));
		banco.inserir(c6);
		banco.inserir(c7);
		System.out.println("Conta 680: " + banco.buscar("680"));


		
	}

}
