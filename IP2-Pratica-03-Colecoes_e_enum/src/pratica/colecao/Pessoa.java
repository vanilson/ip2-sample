package pratica.colecao;

import java.time.LocalDate;

public class Pessoa {
	
	// ATRIBUTOS
	private String cpf;
	private String nome;
	private LocalDate dataNascimento;
	
	// CONSTRUTORES
	public Pessoa() {
		
	}

	public Pessoa(String cpf, String nome, LocalDate dataNascimento) {
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

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
