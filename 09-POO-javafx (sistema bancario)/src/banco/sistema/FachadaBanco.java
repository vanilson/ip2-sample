package banco.sistema;

import java.util.List;

import banco.sistema.conta.Conta;
import banco.sistema.conta.dados.RepositorioContasFile;
import banco.sistema.conta.exceptions.ContaJaExisteException;
import banco.sistema.conta.exceptions.ContaNaoExisteException;
import banco.sistema.conta.exceptions.SaldoInsuficienteException;
import banco.sistema.conta.negocio.ControladorContas;

public class FachadaBanco {
    
	private ControladorContas controladorContas;
	
	private static FachadaBanco instance;
	
	private FachadaBanco () {
	    this.controladorContas = new ControladorContas(RepositorioContasFile.getInstance());
	}
	
	/**
	 * Implementando padrão Singleton
	 * 
	 * @return A instância da desta fachada
	 */
	public static FachadaBanco getInstance() {
        if (instance == null) {
            instance = new FachadaBanco();
        }
        return instance;
    }
	
	/* (non-Javadoc)
     * @see br.ufrpe.sistema_bancario.negocio.IFachada#cadastrarConta(br.ufrpe.sistema_bancario.negocio.beans.Conta)
     */
	public void cadastrarConta(Conta c) throws ContaJaExisteException{
		this.controladorContas.cadastrar(c);
	}
	
	public void atualizar(Conta conta) {
		controladorContas.atualizar(conta);
	}

	/*
	 * (non-Javadoc)
	 * @see br.ufrpe.sistema_bancario.negocio.IFachada#procurarConta(java.lang.String)
	 */
    public Conta procurarConta(String num) {
        return this.controladorContas.procurar(num);
    }
	
	/*
	 * (non-Javadoc)
	 * @see br.ufrpe.sistema_bancario.negocio.IFachada#transferir(java.lang.String, java.lang.String, double)
	 */
    public void transferir(String numOrigem, String numDestino, double valor)
            throws ContaNaoExisteException, SaldoInsuficienteException {
        controladorContas.transferir(numOrigem, numDestino, valor);
    }

    /* (non-Javadoc)
     * @see br.ufrpe.sistema_bancario.negocio.IFachada#removerConta(java.lang.String)
     */
	public void removerConta(String num) throws ContaNaoExisteException {
	    this.controladorContas.remover(num);
	}

	public void cadastrar(Conta c) throws ContaJaExisteException {
		controladorContas.cadastrar(c);
	}

	

	public void descadastrar(String numConta) throws ContaNaoExisteException {
		controladorContas.descadastrar(numConta);
	}

	public Conta procurar(String num) {
		return controladorContas.procurar(num);
	}

	public boolean existe(String numConta) {
		return controladorContas.existe(numConta);
	}

	public void remover(String num) throws ContaNaoExisteException {
		controladorContas.remover(num);
	}

	public void creditar(String num, double valor) {
		controladorContas.creditar(num, valor);
	}

	public void debitar(String num, double valor) {
		controladorContas.debitar(num, valor);
	}

	public boolean equals(Object obj) {
		return controladorContas.equals(obj);
	}

	public double getSaldo(String num) {
		return controladorContas.getSaldo(num);
	}

	public int hashCode() {
		return controladorContas.hashCode();
	}

	public void renderJuros(String num) throws ContaNaoExisteException {
		controladorContas.renderJuros(num);
	}

	public List<Conta> listar() {
		return controladorContas.listar();
	}

	public String toString() {
		return controladorContas.toString();
	}


}
