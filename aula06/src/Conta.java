
public class Conta {

	// ATRIBUTOS
	private String numero;
	public double saldo;

	// CONSTRUTOR
	public Conta(String numero, double saldo) {
		this.numero = numero;
		this.saldo = saldo;
	}

	public Conta() {
		this.numero = "123";
		this.saldo = 100;
	}

	// METODOS
	public void creditar(double valor) {
		if (valor > 0) {
			this.saldo = this.saldo + valor;
		} else {
			System.out.println("Informe um valor positivo!");
		}
	}

	public void debitar(double valor) {
		if (this.saldo >= valor) {
			this.saldo -= valor;
		} else {
			System.out.println("Saldo insuficiente!");
		}
	}
	
	public boolean transferir(double valor, Conta contaDestino) {
		boolean x = false;
		if(contaDestino != null && valor <= this.saldo){
			this.debitar(valor);
			contaDestino.creditar(valor);
			x = true;
		}
		return x;
	}
	
	public String getNumero() {
		return this.numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	
	public boolean equals(Conta conta) {
		boolean igual = false;
		if(conta != null && this.numero.equals(conta.getNumero())){
			igual = true;
		}
		return igual;
	}

	@Override
	public String toString() {
		String retorno = "Conta [numero=" + this.numero + ", saldo=" + this.saldo + "]";
		return retorno;
	}

}
