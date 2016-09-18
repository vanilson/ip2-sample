package poo.heranca;

public class Professor extends Pessoa {
	private double salario;
	private int nivel;
	
	public Professor() {
		super(); // chamada ao construtor default da superclasse (Pessoa)
	}
	
	public Professor(String cpf, String nome, String email, double salario, int nivel) {
		super(cpf, nome, email);  // chamada ao construtor da super classe
		
		// atributos específicos de Professor
		this.salario = salario;
		this.nivel = nivel;
	}

	
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	

}
