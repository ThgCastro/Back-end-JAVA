package com.unip.crud.services;

import com.unip.crud.model.Cliente;
import com.unip.crud.model.Endereco;
import com.unip.crud.repositories.ClienteRepository;
import com.unip.crud.repositories.EnderecoRepository;
import com.unip.crud.services.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public ClienteService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }


    public List<Cliente> findAllCliente(){
        return clienteRepository.findAll();
    }

    public Cliente findClienteById(Long id){
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Cliente saveCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void deleteClienteById (Long id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente nao encontrado"));
        enderecoRepository.deleteAll(cliente.getEnderecos());
        clienteRepository.deleteById(id);
    }
}
