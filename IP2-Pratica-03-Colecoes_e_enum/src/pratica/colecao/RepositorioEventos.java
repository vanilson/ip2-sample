package pratica.colecao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;



public class RepositorioEventos {
	
	Map<String, Evento> eventos;

	public RepositorioEventos(Evento[] eventos) {
		
		this.eventos = new HashMap();
		
		// adicionar no Map os eventos
		for (Evento ev : eventos) {
			if (ev != null) {
				this.eventos.put(ev.getNome(), ev);
			}
		}
		
	}
	
	public Evento buscar(String nome) {
		return this.eventos.get(nome);
	}
	
	public void adicionar(Evento evento) {
		if (evento != null) {
			this.eventos.put(evento.getNome(), evento);
		} 
		
		
	}

	public Collection<Evento> listarTodos() {
		return this.eventos.values();
	}

	public Set<String> listarNomesDosEventos() {
		return this.eventos.keySet();
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

//		this.eventos.values().stream().forEach(e -> sb.append(e.toString() + "\n"));
		this.eventos.values().stream().forEach(sb::append);

		
		return sb.toString();
		
	}
} 
