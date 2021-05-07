package pratica;

import java.time.LocalDate;

public class Programa {

	public static void main(String[] args) {
		RepositorioPessoa repositorio = new RepositorioPessoa();
		
		Pessoa p1 = new Pessoa("123", "Jose", LocalDate.of(1999, 5, 22));
		Pessoa p2 = new Pessoa("234", "Maria", LocalDate.of(2000, 4, 18));
		Pessoa p3 = new Pessoa("345", "Joao", LocalDate.of(2010, 4, 29));
		
		Aluno a1 = new Aluno();
		a1.setNome("Aluno 01");
		a1.setCpf("1292");
		
		Aluno a2 = new Aluno("MAT-002", "567", "Aluno 02", LocalDate.of(2010, 4, 29));
		a2.setCurso("Licenciatura em Computacao");
		
		Professor prof1 = new Professor("3336", "Prof. Jose", "Engenharia de Software");
		
		
		a1.setMatricula("MAT-001");
		a1.setCurso("Ciencia da Computacao");
		
		Pessoa p4 = new Aluno();
		
		
		repositorio.adicionar(p1);
		repositorio.adicionar(p2);
		repositorio.adicionar(p3);
		
		repositorio.adicionar(a2);
		
		repositorio.adicionar(prof1);
		
		String cpf = "389383938";
		Pessoa p = repositorio.buscar(cpf);
		
		// CAST
		if (p instanceof Aluno) {
			Aluno a = (Aluno) p;
			System.out.println("Aluno: " + p.getNome() + " | Mat: " + a.getMatricula() + " | Curso: " + a.getCurso());
		
		} else if (p instanceof Professor) {
			String area = ((Professor) p).getArea();
			System.out.println("Professor: " + p.getNome() + " | CPF: " + p.getCpf() + " | Area: " + area);
		
		} else { 
			if (p != null) {
				System.out.println("Pessoa: " + p.getNome() + " | CPF: " + p.getCpf());
			} else {
				System.out.println("Pessoa nao encontrada!! CPF: " + cpf);
			}
		}

		
		
//		repositorio.remover("234");
		
		
		Pessoa pessoa = repositorio.buscar("567");
		
		if (pessoa != null) {
			System.out.println("Nome da pessoa encontrada: " + pessoa.getNome());
		}
		

	}

}
