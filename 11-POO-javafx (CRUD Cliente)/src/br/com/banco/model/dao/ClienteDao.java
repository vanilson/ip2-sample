package br.com.banco.model.dao;

import br.com.banco.model.domain.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClienteDao extends GenericAbstractCrudDao<Cliente> {

    public ClienteDao() {}

    @Override 
    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        for (Object o : getDatabase()) {
            if (o instanceof Cliente) {
                clientes.add((Cliente) o);
            }
        }
        return clientes;
    }
    
    public List<Cliente> listarPeloNome(String nome) {
        Stream<Cliente> streamClienteFiltro = this.listar().stream();
        return streamClienteFiltro.filter(c -> !c.getNome().isEmpty() && c.getNome().toLowerCase().contains(nome.toLowerCase())).collect(Collectors.toList());
    }
    
    public List<Cliente> listarMaioresDeIdade()  {
        Stream<Cliente> streamClienteFiltro = this.listar().stream();
        return streamClienteFiltro.filter(c -> c.getIdade(c.getDataNascimento()) > 18).collect(Collectors.toList());
    }         
 }

