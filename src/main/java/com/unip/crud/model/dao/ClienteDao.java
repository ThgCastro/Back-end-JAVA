package com.unip.crud.model.dao;

import com.unip.crud.model.Cliente;

import java.util.List;

public interface ClienteDao {

    void createCliente(Cliente c);
    List<Cliente> viewCliente();
    void updateCliente(Long id, String newNome);
    void deleteCliente(Long id);
}
