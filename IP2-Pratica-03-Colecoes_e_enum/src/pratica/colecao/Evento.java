package pratica.colecao;
//Atividade: https://docs.google.com/document/u/0/d/10H6DOpuGjBnimmZPbEaRebwjxqb30jfXgl38BMVOj9M/edit
//quadro: https://jamboard.google.com/u/0/d/1mR74sw1eR34dP_MnvYhYMkreh0v9uSw0q_njmxu7Rg0/viewer?usp=meet_whiteboard

import java.time.LocalDateTime;

public class Evento {
	
	// ATRIBUTOS
	private String nome;
	private CidadeEnum local;
	private LocalDateTime dataHora;
	
	// CONSTRUTOR
	public Evento(String nome, CidadeEnum local, LocalDateTime dataHora) {
		super();
		this.nome = nome;
		this.local = local;
		this.dataHora = dataHora;
	}

	@Override
	public String toString() {
		return this.nome + " - " + this.local.name() + "\n"; // complementar com a data formatada!
	}
	
	// METODOS GET/SET
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public CidadeEnum getLocal() {
		return local;
	}

	public void setLocal(CidadeEnum local) {
		this.local = local;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	
	
	
	
	


}
