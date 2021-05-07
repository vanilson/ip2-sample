package pratica;

import java.time.LocalDate;

public class Aluno extends Pessoa {
	
	// ATRIBUTOS
	private String matricula;
	private String curso;
	
	// CONSTRUTOR
	public Aluno() {
		
	}
	
	public Aluno(String matricula, String cpf, String nome, LocalDate dataNascimento) {
		super(cpf, nome, dataNascimento);
		this.matricula = matricula;
	}

	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	

}
