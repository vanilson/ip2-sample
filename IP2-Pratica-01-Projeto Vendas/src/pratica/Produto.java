package pratica;

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
