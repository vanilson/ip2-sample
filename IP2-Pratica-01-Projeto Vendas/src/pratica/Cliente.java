package pratica;

import java.time.LocalDate;

public class Cliente {
	
	// ATRIBUTOS
	private String cpf;
	private String nome;
	private LocalDate dataNascimento;

	// CONSTRUTORES
	public Cliente() {

	}
	
	public Cliente(String cpf, String nome) {
		this.cpf = cpf;
		this.nome = nome;
	}

	public Cliente(String cpf, String nome, LocalDate dataNascimento) {
		this(cpf, nome);
		this.dataNascimento = dataNascimento;				
	}
	
	// Métodos GET/SET
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	
}
