package com.unip.crud.model.dao;

import com.unip.crud.model.Cliente;

import java.util.List;

public interface ClienteDao {

    void createCliente(Cliente c);
    List<Cliente> viewClienteById(Long id);
    void updateClienteById(Long id, String newNome);
    void deleteClienteById(Long id);
}
