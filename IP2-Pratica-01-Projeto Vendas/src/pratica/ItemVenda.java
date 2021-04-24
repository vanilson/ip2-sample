package pratica;

public class ItemVenda {
	
	// ATRIBUTOS
	private int quantidade;
	private Produto produtoVendido;
	
	public ItemVenda(int qtd, Produto produto) {
		this.quantidade = qtd;
		this.produtoVendido = produto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Produto getProdutoVendido() {
		return produtoVendido;
	}
	public void setProdutoVendido(Produto produtoVendido) {
		this.produtoVendido = produtoVendido;
	}

	public double calcularTotal() {
		return this.quantidade * this.produtoVendido.getPreco();
	}
	
	@Override
	public String toString() {
		return "Qtd: " + this.getQuantidade() + 
				" | Preço Unidade: " + this.getProdutoVendido().getPreco() + 
				" | Total: " + this.calcularTotal() + 
				" | Produto: " + this.getProdutoVendido().getNome();
	}
	
	
}
