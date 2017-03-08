package banco.sistema.conta.negocio;
import java.util.List;

import banco.sistema.conta.Conta;
import banco.sistema.conta.Poupanca;
import banco.sistema.conta.dados.IRepositorioContas;
import banco.sistema.conta.exceptions.ContaJaExisteException;
import banco.sistema.conta.exceptions.ContaNaoExisteException;
import banco.sistema.conta.exceptions.SaldoInsuficienteException;

public class ControladorContas {

    private IRepositorioContas repositorioContas;
    
    public ControladorContas(IRepositorioContas instanciaRepositorio) {
        this.repositorioContas = instanciaRepositorio; 
    }
    
    public void cadastrar(Conta c) throws ContaJaExisteException {
        if (c == null) {
            throw new IllegalArgumentException("Parâmetro inválido");
        } else {
            if (!this.existe(c.getNumero())) {
                this.repositorioContas.inserir(c);
            } else {
                throw new ContaJaExisteException(c.getNumero());
            }
        }        
    }
    
    public void descadastrar(String numConta) throws ContaNaoExisteException {
    	Conta c = this.repositorioContas.consultar(numConta);
    	if (c != null &&
    			c.getSaldo() == 0) {
    		this.repositorioContas.remover(numConta);
		} else {
			throw new ContaNaoExisteException(numConta);
		}
    }

    public Conta procurar(String num) {
        return this.repositorioContas.consultar(num);
    }
    
    public boolean existe(String numConta) {
    	return this.repositorioContas.existe(numConta);
    }

    public void remover(String num) throws ContaNaoExisteException {
        this.repositorioContas.remover(num);
    }

    /**
     * Procura a conta cujo número é passado como parâmetro e credita o valor
     * também passado como parâmetro
     * 
     * @param num Número da conta a ser procurada
     * @param valor Valor a ser creditado na conta encontrada
     */
    public void creditar(String num, double valor) {
        Conta contaCredito = this.repositorioContas.consultar(num);
        if (contaCredito != null) {
            contaCredito.creditar(valor);
        }
    }
    
    /**
     * Procura a conta cujo número é passado como parâmetro e debita o valor
     * também passado como parâmetro. Note que não é preciso testar se o saldo é
     * válido para realizar o débito porque o método "debitar" da classe Conta
     * já testa essa situação
     * 
     * @param num Número da conta a ser procurada
     * @param valor Valor a ser debitado na conta encontrada
     */
    public void debitar(String num, double valor) {
        Conta contaDebito = this.repositorioContas.consultar(num);
        if (contaDebito != null) {
            contaDebito.debitar(valor);
        }
    }
    
    /**
     * Realiza transferência de valores entre as duas contas a partir dos
     * números das contas passados como parâmetro
     * 
     * @param numOrigem Número da conta origem
     * @param numDestino Número da conta destino
     * @param valor Valor a ser transferido
     * @throws ContaNaoExisteException 
     * @throws SaldoInsuficienteException 
     */
    public void transferir(String numOrigem, String numDestino, double valor) 
            throws ContaNaoExisteException, SaldoInsuficienteException {
        Conta origem = this.repositorioContas.consultar(numOrigem);
        Conta destino = this.repositorioContas.consultar(numDestino);
        if (origem != null && destino != null && origem.getSaldo() >= valor) {
            origem.debitar(valor);
            destino.creditar(valor);
        } else {
            if (origem == null) {
                throw new ContaNaoExisteException(numOrigem);
            } else if (origem.getSaldo() < valor){
                throw new SaldoInsuficienteException(numOrigem);
            }
            if (destino == null) {
                throw new ContaNaoExisteException(numDestino);
            }
        }
    }
    
    public double getSaldo(String num) {
        Conta c = this.repositorioContas.consultar(num);
        return c.getSaldo();
    }
    
    public static final double TAXA_JUROS = 0.01;
    
    public void renderJuros(String num) throws ContaNaoExisteException {
        Conta c = this.repositorioContas.consultar(num);
        if (c instanceof Poupanca) {
            ((Poupanca) c).renderJuros(TAXA_JUROS);
            this.repositorioContas.atualizar(c);
        } else {
            throw new ContaNaoExisteException(num);
        }
    }
    
    public List<Conta> listar() {
    	return repositorioContas.listarTodas();
    }
    
    public void atualizar(Conta conta) {
    	repositorioContas.atualizar(conta);
    }
    
}
