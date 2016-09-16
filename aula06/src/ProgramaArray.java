import java.util.Arrays;

public class ProgramaArray {

	public static void main(String[] args) {
		Conta[] contas = new Conta[10];
		Conta c = new Conta();
		System.out.println(c);
		
		for(int i=0;i< contas.length;i++){
			contas[i] = new Conta(i+"", i*10);
		}
		
		int x = 10;
		
		m(x);
		m(x);
		m(x);
		m(x);
		m(x);
		System.err.println(x);
		
	/*	for(Conta aux : contas){
			System.out.println(aux);
		}
		*/
		
		System.out.println(Arrays.toString(contas));
		
		
		
	}
	
	static void m(int x) {
		x = 50;
	}

}
