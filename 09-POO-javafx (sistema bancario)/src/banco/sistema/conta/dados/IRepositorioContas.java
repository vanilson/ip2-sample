package banco.sistema.conta.dados;

import java.util.List;

import banco.sistema.conta.Conta;
import banco.sistema.conta.exceptions.ContaNaoExisteException;


public interface IRepositorioContas {

    /**
     * Insere uma nova conta no array de contas.
     * 
     * @param c
     *        A referencia da conta a ser cadastrada
     */
    void inserir(Conta c);

    /**
     * Atualiza conta no array de contas.
     * 
     * @param c
     *        A referencia da conta a ser cadastrada
     */
    void atualizar(Conta c);

    /**
     * Procurar uma conta baseado no numero dado como parametro
     * 
     * @param num
     *            O numero da conta a ser procurada
     * @return A conta encontrada ou null se o numero de conta passado com
     *         parametro nao existir
     */
    Conta consultar(String num);

    /**
     * Verifica se a conta de codigo informado existe no repositorio
     * 
     * @param numConta
     * @return
     */
    boolean existe(String numConta);

    /**
     * Removendo a conta cujo numero eh passado como parametro
     * 
     * @param num
     *            Numero da conta a ser removida.
     * @throws ContaNaoExisteException 
     */
    void remover(String num) throws ContaNaoExisteException;

    /**
     * M�todo que retorna todas as contas
     * 
     */
    List<Conta> listarTodas();

    /**
     * Metodo que procura por contas cujo saldo eh maior do que o salario informado e retorna em
     * formato de Array
     * 
     * @return Array de Contas cujo saldo eh maior do que 1000
     */
    List<Conta> listar(double salario);

}