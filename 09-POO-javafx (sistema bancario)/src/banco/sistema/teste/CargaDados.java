package banco.sistema.teste;

import banco.sistema.FachadaBanco;
import banco.sistema.conta.Conta;
import banco.sistema.conta.exceptions.ContaJaExisteException;

public class CargaDados {

	public static final void main(String args[]) {

		// cadastro de contas
		String nomes[] = {"Maria Jose", "Jose Maria", "Joao", "Andre", "Vanilson", "Tereza", "Gabriela", "Vivian", "Theo"};
		FachadaBanco fachada = FachadaBanco.getInstance();
		try {
			for (int i = 0; i < nomes.length; i++) {
				fachada.cadastrarConta(new Conta(nomes[i], "000-"+i, i*1000d));
			}

		} catch (ContaJaExisteException e) {
			// Tratando erro
			System.out.println(e.getMessage());
		}
	}

}
