package pratica;

// https://app.diagrams.net/#G1RbuaBkZMSKEuf1JW-9A2TiqHgiiGm4RD
// quadro: https://jamboard.google.com/u/0/d/1mR74sw1eR34dP_MnvYhYMkreh0v9uSw0q_njmxu7Rg0/viewer?usp=meet_whiteboard
public class Produto {
	
	// ATRIBUTOS
	private int codigo;  // estudar conceito de ocultação de informação
	private String nome;
	private String descricao;
	private double preco;
	
	// CONSTRUTORES
	public Produto() {
		
	}
	
	public Produto(int codigo, String nome, double preco) {
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
	}
	
	public Produto(int codigo, String nome, String desc, double preco) {
		this(codigo, nome, preco);
		this.descricao = desc;
		
	}
	
	// Métodos GET/SET
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
	
}
