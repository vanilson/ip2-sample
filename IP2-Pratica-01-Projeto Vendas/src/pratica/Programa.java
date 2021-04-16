package pratica;

public class Programa {

	public static void main(String[] args) {
		System.out.println("Olá Turma! Vamos das as boas vindas a Jael!");
		
		// INSTANCIANDO PRODUTOS
		Produto p1 = new Produto();
		Produto p2 = new Produto(2, "Teclado", 50D);
		
		p1.setCodigo(1);
		p1.setNome("Mouse");
		p1.setDescricao("Equipamento periférico");
		p1.setPreco(10.50);
		
		System.out.println("P2: " + p2.getCodigo() + " | Nome: " + p2.getNome());

		// INSTANCIANDO CLIENTES
		Cliente c1 = new Cliente("123", "Jose Silva");
		System.out.println("Cliente: " + c1.getCpf() + " | Nome: " + c1.getNome());


		Venda venda = new Venda();
		venda.setConsumidor(c1);

		System.out.println("Consumidor: " + venda.getConsumidor().getCpf() + " | Nome: " + venda.getConsumidor().getNome());
		venda.getConsumidor().setNome("Maria José");
		
		System.out.println("Cliente: " + c1.getCpf() + " | Nome: " + c1.getNome());
		
		ItemVenda item1 = new ItemVenda(10, p1);
		venda.adicionarItem(item1);
		
		venda.adicionarItem(new ItemVenda(20, p2));
		
		System.out.println("Total de Itens da Venda: " + venda.getItens().size());
		

	
	}

}
