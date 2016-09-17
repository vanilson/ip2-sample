package br.ufrpe.poo.beans;

public class Cliente {
	long cpf;
	String nome;
	String sobrenome;
	
	public Cliente(long cpf, String nome, String sobrenome) {
		this.cpf = cpf;
		this.nome = nome;
		this.sobrenome = sobrenome;
	}
	
	public String obterNomeCompleto(String nome) {
		return this.nome + " " + this.sobrenome;
	}
	
}
