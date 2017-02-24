package funcionario;

import java.util.List;

public interface IRepositorioFuncionario {
	
	void inserir(Funcionario funcionario);
	void remover(Funcionario funcionario);
	void atualizar(Funcionario funcionario);
	Funcionario buscarPorId(Long id);

	List<Funcionario> listarTodos();
	List<Funcionario> listarTodosOrdenadosPorSalario();
	List<Funcionario> listarTodosOrdenadosPorIdade();
	List<Funcionario> listarTodosOrdenadosPorNome();

	List<Funcionario> buscarPorSalarioMaiorQue(double valor);
	List<Funcionario> buscarPorNomeComecandoPor(String nome);
}
