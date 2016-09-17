package br.ufrpe.poo.repositorio;

import br.ufrpe.poo.beans.Conta;

public class RepositorioContasTurma {

	private Conta[] contas;

	public RepositorioContasTurma(int tam) {
		this.contas = new Conta[tam];

	}

	public Conta[] getContas() {
		return contas;
	}

	public void setContas(Conta[] contas) {
		this.contas = contas;
	}

	public void inserir(Conta c) {
		if(c == null || c.getNumero() == null) {
			return;
		}
	
		for (int i = 0; i < contas.length; i++) {
			if (contas[i] == null) {
				contas[i] = c;
				break;
			}
		}
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

		for (int i = 0; i < contas.length; i++) {
			if (contas[i] != null) {
				if (contas[i].getNumero().equals(num)) {
					contas[i] = null;
				}
			}
		}

	}
}
