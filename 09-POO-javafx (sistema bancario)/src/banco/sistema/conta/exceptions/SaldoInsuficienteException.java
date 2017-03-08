package banco.sistema.conta.exceptions;

public class SaldoInsuficienteException extends Exception {
    
    private String numero;
    
    public SaldoInsuficienteException(String num) {
        super("O saldo da conta de número " + num + " é insuficiente "
                + "para realizar a transaçao.");
        this.numero = num;
    }

    public String getNumero() {
        return numero;
    }
}
