package br.com.banco.model.facade;

import br.com.banco.model.domain.Cliente;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;


public interface ClienteFacade {

    Cliente salvar(Cliente cliente);
    void remover(Cliente cliente);
    Cliente editar(Cliente cliente);
    List<Cliente> listarTodos();
    List<Cliente> listarPeloNome(String nome);
    
    //default methods
    public default boolean isAniversariante(Cliente c) {
        LocalDate dataAtual = LocalDate.now();
        LocalDate dataNasc = LocalDateTime.ofInstant(c.getDataNascimento().toInstant(), ZoneId.systemDefault()).toLocalDate();
        Period periodo = Period.between(dataAtual, dataNasc);       
        return periodo.getDays() == 0 && periodo.getMonths() == 0;
    }
}
