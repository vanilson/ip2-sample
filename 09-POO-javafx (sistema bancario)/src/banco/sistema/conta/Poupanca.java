package banco.sistema.conta;

import java.io.Serializable;

public class Poupanca extends Conta implements Serializable {

    public Poupanca(String cliente, String numero){
        super(cliente, numero, 0.0);
    }
    
    public void renderJuros(double taxa) {
        this.creditar(this.getSaldo()*taxa);
    }
    
}
