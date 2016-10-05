package poo.heranca;

public class Programa {

	public static void main(String[] args) {
		Pessoa p = new Pessoa("123", "Jose", "jose@gmail.com");
		Professor prof = new Professor("123", "Jose", "jose@gmail.com", 929, 1);
		
		
		Pessoa p2 = p;
		
		if (p2 instanceof Professor) {
			((Professor)p2).setSalario(890);
		}
		
		if (p2 instanceof Professor) {
			Professor prof2 = (Professor) p2;
		}
		
		
		
		
		System.out.println("Fim do programa!!");
		
		
	
		
		
	}

}
