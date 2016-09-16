package br.ufrpe.poo.repositorio;

import br.ufrpe.poo.beans.Conta;

public class RepositorioConta {

	private int proxima; // representa a posicao da prox. conta a ser inserida
	private Conta[] contas;

	public RepositorioConta(int tam) {
		this.contas = new Conta[tam];
		this.proxima = 0;
	}

	public Conta[] getContas() {
		return contas;
	}

	public void setContas(Conta[] contas) {
		this.contas = contas;
	}

	public void inserir(Conta c) {
		if (this.proxima == this.contas.length) {
			System.out.println("Banco lotado!!!");
			return;
		}
		
		this.contas[this.proxima] = c;
		this.proxima++;
	}

	public Conta buscar(String num) {
		for (int i = 0; i < contas.length; i++) {
			if (contas[i] != null) {
				if (contas[i].getNumero().equals(num)) {
					return contas[i];
				}
			}
		}
		return null;
	}

	public void remover(String num) {
		
	}
	
	public int getQuantidadeContas() {
		return this.proxima;
	}
}
