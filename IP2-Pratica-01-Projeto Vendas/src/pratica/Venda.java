package pratica;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Venda {
	
	private LocalDateTime data;
	private String atendente;
	private Cliente consumidor;
	private List<ItemVenda> itens = new ArrayList<>();
	
	public void adicionarItem(ItemVenda item) {
		this.itens.add(item);
	}
	
	// GET/SET
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	public String getAtendente() {
		return atendente;
	}
	public void setAtendente(String atendente) {
		this.atendente = atendente;
	}
	public Cliente getConsumidor() {
		return consumidor;
	}
	public void setConsumidor(Cliente consumidor) {
		this.consumidor = consumidor;
	}
	
	public List getItens() {
		return this.itens;
	}
	
	

}
