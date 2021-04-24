package pratica;

import java.time.LocalDate;
import java.time.LocalDateTime;

//Diagrama: https://app.diagrams.net/#G1RbuaBkZMSKEuf1JW-9A2TiqHgiiGm4RD
//quadro: https://jamboard.google.com/u/0/d/1mR74sw1eR34dP_MnvYhYMkreh0v9uSw0q_njmxu7Rg0/viewer?usp=meet_whiteboard

public class ProgramaVenda {

	public static void main(String[] args) {
		System.out.println("Olá Turma! Vamos das as boas vindas a Jael!");
		
		// INSTANCIANDO PRODUTOS
		Produto mouse = new Produto();
		mouse.setCodigo(1);
		mouse.setNome("Mouse");
		mouse.setDescricao("Equipamento periférico");
		mouse.setPreco(55);

		Produto teclado = new Produto(2, "Teclado", 50D);

		
		System.out.println("P2: " + teclado.getCodigo() + " | Nome: " + teclado.getNome());

		// INSTANCIANDO CLIENTES
		LocalDate dataNasc = LocalDate.of(1985, 1, 17);
		Cliente c1 = new Cliente("123", "Jose Silva", dataNasc);
		
		System.out.println("Cliente: " + c1.getCpf() + " | Nome: " + c1.getNome() + " | Idade: " + c1.calcularIdade());

		Venda venda = new Venda();
		venda.setData(LocalDateTime.of(2021, 4, 22, 4, 30));
		venda.setConsumidor(c1);
		venda.setAtendente("Maria Jose");
		
		// Adicionar itens de Venda
		ItemVenda item1 = new ItemVenda(10, mouse);
		ItemVenda item2 = new ItemVenda(20, teclado);

		venda.adicionarItem(item1);
		venda.adicionarItem(item2);
		
		System.out.println("Total da Venda: " + venda.calcularTotal());
		venda.listarItensVenda();
		
		System.out.println(venda); // toString foi chamado implicitamente
		

	
	}

}
