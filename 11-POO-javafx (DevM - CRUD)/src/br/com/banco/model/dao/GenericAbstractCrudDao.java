package br.com.banco.model.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericAbstractCrudDao<T extends Serializable> { 
  
    public abstract List<T> listar();
    
    private static List<Object> database = null;
    
    public GenericAbstractCrudDao() {
        database = new ArrayList<>();
    }

    public T salvar(T entity) {
        getDatabase().add(entity);
        return entity;
    }
    
    public T editar(T entity) {
        getDatabase().remove(entity);
        getDatabase().add(entity);
        return entity;
    }

    public void remover(T entity) {
        getDatabase().remove(entity);
    }

    public static List<Object> getDatabase() {
        return database;
    }
}
