package pratica.colecao;

import static pratica.colecao.CidadeEnum.*;

import java.time.LocalDateTime;
import java.util.Set;

public class ProgramaEvento {

	public static void main(String[] args) {
		
		Evento[] eventos = new Evento[10];
		
		eventos[0] = new Evento("Aula de IP2", RECIFE, LocalDateTime.of(2021, 5, 21, 8, 30));
		eventos[1] = new Evento("Aula de Web", SALVADOR, LocalDateTime.of(2021, 5, 21, 8, 30));
		eventos[2] = new Evento("Aula de Apps Moveis", RECIFE, LocalDateTime.of(2021, 5, 21, 8, 30));
		eventos[3] = new Evento("Aula de Algoritmo", RECIFE, LocalDateTime.of(2021, 5, 21, 8, 30));
		eventos[4] = new Evento("Aula de Programacao 1", RECIFE, LocalDateTime.of(2021, 5, 21, 8, 30));
		
		
		RepositorioEventos repoEventos = new RepositorioEventos(eventos);
		
		Evento evento = repoEventos.buscar("Aula de Web");
		System.out.println("Local: " + evento.getLocal().name());
		
		
		Evento novoEvento = new Evento("Aula Sincrona", NATAL, LocalDateTime.of(2021, 5, 21, 8, 30));
		
		repoEventos.adicionar(novoEvento); 
		
		Set<String> nomesDosEventos = repoEventos.listarNomesDosEventos();
		System.out.println("Eventos: " + nomesDosEventos);
		
		System.out.println(repoEventos);

	}

}
