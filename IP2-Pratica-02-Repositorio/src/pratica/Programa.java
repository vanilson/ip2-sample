package pratica;

import java.time.LocalDate;

public class Programa {

	public static void main(String[] args) {
		RepositorioPessoa repositorio = new RepositorioPessoa();
		
		Pessoa p1 = new Pessoa("123", "Jose", LocalDate.of(1999, 5, 22));
		Pessoa p2 = new Pessoa("234", "Maria", LocalDate.of(2000, 4, 18));
		Pessoa p3 = new Pessoa("345", "Joao", LocalDate.of(2010, 4, 29));
		
		repositorio.adicionar(p1);
		repositorio.adicionar(p2);
		repositorio.adicionar(p3);
		
		Pessoa p = repositorio.buscar("234");
		System.out.println("Nome da pessoa encontrada: " + p.getNome());

//		repositorio.remover("234");
		
		
		Pessoa pessoa = repositorio.buscar("234");
		
		if (pessoa != null) {
			System.out.println("Nome da pessoa encontrada: " + pessoa.getNome());
		}
		

	}

}
