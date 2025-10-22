package com.unip.crud.services;

import com.unip.crud.model.Cliente;
import com.unip.crud.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public void saveCliente(Cliente cliente){
        repository.saveAndFlush(cliente);
    }
}
