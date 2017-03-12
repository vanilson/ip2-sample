package br.com.banco.model.facade.impl;

import static br.com.banco.controller.ClienteController.dataFormatter;
import br.com.banco.model.dao.ClienteDao;
import br.com.banco.model.domain.Cliente;
import br.com.banco.model.facade.ClienteFacade;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteFacadeImpl implements ClienteFacade {

    private ClienteDao clienteDao; 
    
    public ClienteFacadeImpl() {
        clienteDao = new ClienteDao();
    }
    
    @Override
    public Cliente salvar(Cliente cliente) {
        return clienteDao.salvar(cliente);
    }

    @Override
    public List<Cliente> listarTodos() {
        return clienteDao.listar();
    }

    @Override
    public void remover(Cliente cliente) {
       clienteDao.remover(cliente);
    }

    @Override
    public Cliente editar(Cliente cliente) {
       return clienteDao.editar(cliente);
    }

    @Override
    public List<Cliente> listarPeloNome(String nome) {
        return clienteDao.listarPeloNome(nome);
    }
    
    public static void main(String args[]) throws RemoteException {
        Date releaseDate = null;
        try {
             releaseDate = dataFormatter.parse("02/02/1985");
        } catch (ParseException ex) {
            Logger.getLogger(ClienteFacadeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Cliente cliente = new Cliente("Carlos Alberto Silva", "06701676650", releaseDate, "88888888");
        ClienteFacade facade = new ClienteFacadeImpl();
        System.out.println(facade.isAniversariante(cliente));
    }
    
}
