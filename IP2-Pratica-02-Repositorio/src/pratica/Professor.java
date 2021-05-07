package pratica;

public class Professor extends Pessoa {

	private String area;
	private String nivel;
	private String salario;
	
	// CONSTRUTOR
	public Professor(String cpf, String nome, String area) {
		
		super.setCpf(cpf);
		super.setNome(nome);
		
		this.area = area;
	}
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public String getSalario() {
		return salario;
	}
	public void setSalario(String salario) {
		this.salario = salario;
	}
	
	
	
}
