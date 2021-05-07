package pratica;

import java.time.LocalDate;

public class Programa2 {

	public static void main(String[] args) {
		
		RepositorioPessoa repositorio = new RepositorioPessoa();
		
		Pessoa pessoa = new Pessoa("123", "Jose", LocalDate.of(1999, 5, 22));
		Aluno aluno = new Aluno("MAT-001", "567", "Aluno 01", LocalDate.of(2010, 4, 29));
		Professor professor = new Professor("333", "Prof. Jose", "Engenharia de Software");
	
		pessoa = professor;

		// Nao é possivel:
//		professor = aluno;
//		aluno = professor;
//		aluno = pessoa;
//		professor = pessoa;
		
		if (pessoa instanceof Professor) {
			System.out.println("CPF: " + pessoa.getCpf() + " | Area: " + ((Professor) pessoa).getArea());
		}
		
	}
		
		
}
