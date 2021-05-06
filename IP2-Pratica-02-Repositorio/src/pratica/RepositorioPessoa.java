package pratica;

public class RepositorioPessoa {
	
	private Pessoa[] pessoas;
	private int posicao; // representa a posição onde o próximo elemento será inserido
	
	public RepositorioPessoa() {
		this.pessoas = new Pessoa[100];
		this.posicao = 0;
	}
	
	public void adicionar(Pessoa pessoa) {
		
		if (this.posicao >= this.pessoas.length) {
			System.out.println("Limite de pessoas atingido!!");
			return;
		}
		
		System.out.println("Inserindo pessoa [CPF: " + pessoa.getCpf() + "] na posicao: " + posicao);
		this.pessoas[posicao] = pessoa;
		this.posicao++;
	}
	
	public Pessoa buscar(String cpf) {
		int indice = this.buscarPosicao(cpf);
		
		if (indice != -1) {
			return this.pessoas[indice];
		}
		
		System.out.println("Pessoa nao encontrada | CPF: " + cpf);
		return null;
	}
	
	public int buscarPosicao(String cpf) {
		
		for (int i = 0; i < this.posicao; i++) {
			if (this.pessoas[i].getCpf().equals(cpf)) {
				return i;
			}
		}
		
		return -1;
	}

	public void remover(String cpf) {
		int posRemover = this.buscarPosicao(cpf);
		
		if (posRemover == -1) {
			System.out.println("Pessoa nao encontrada! CPF: " + cpf);
		}
		
		this.pessoas[posRemover] = this.pessoas[posicao-1];
		this.pessoas[posicao-1] = null;
		this.posicao =- 1;
		
	}
}
