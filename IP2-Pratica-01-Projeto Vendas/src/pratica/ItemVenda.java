package pratica;

public class ItemVenda {
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
	
	
}
