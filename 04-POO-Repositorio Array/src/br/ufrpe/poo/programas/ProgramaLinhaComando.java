package br.ufrpe.poo.programas;

import java.util.Scanner;

import br.ufrpe.poo.beans.Conta;
import br.ufrpe.poo.repositorio.RepositorioConta;

public class ProgramaLinhaComando {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite a quantidade maxima de contas do banco:");

		// lendo dados do teclado....
		int capacidadeMaxima = teclado.nextInt();

		RepositorioConta banco = new RepositorioConta(capacidadeMaxima);
	}
}
