
public class ProgramaCliente {

	public static void main(String[] args) {
		Cliente cli = new Cliente(171871, "Jose", "Silva");
		
		System.out.println("Nome: " + cli.nome);
		System.out.println("Nome do cliente criado: " + cli.obterNomeCompleto(null));
		Conta c  = new Conta("123", 50);
		Conta c2 = new Conta("123", 50);
		
		c2.setAno("00");
		c.setAno("00");
		
	}

}
