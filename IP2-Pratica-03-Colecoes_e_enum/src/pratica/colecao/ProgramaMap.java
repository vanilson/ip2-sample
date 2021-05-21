package pratica.colecao;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ProgramaMap {
	
	public static void main(String[] args) {
		Map<String, Pessoa> map = new HashMap();
		
		Pessoa pessoa = new Pessoa("123426", "Jose", LocalDate.of(1990, 5, 22));
	
		map.put(pessoa.getCpf(), pessoa);
		
		Pessoa pessoaRetornada = map.get("123426");
		System.out.println("pessoaRetornada: " + pessoaRetornada.getNome());
		
	}

}
