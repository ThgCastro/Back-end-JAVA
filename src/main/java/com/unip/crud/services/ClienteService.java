package com.unip.crud.services;

import com.unip.crud.model.Cliente;
import com.unip.crud.repositories.ClienteRepository;
import com.unip.crud.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public void createCliente(Cliente cliente){
        clienteRepository.save(cliente);
    }

    public List<Cliente> findAllCliente(){
        return clienteRepository.findAll();
    }

    public Cliente findClienteById(Long id){
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void deleteClienteById (Long id){
        clienteRepository.deleteById(id);
    }

    public void updateClienteById(Long id, Cliente clienteAtualizado){
        Cliente clienteExistente = clienteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

        if(clienteAtualizado.getNome() != null){
            clienteExistente.setNome(clienteAtualizado.getNome());
        }
        if(clienteAtualizado.getCpf() != null){
            clienteExistente.setCpf(clienteAtualizado.getCpf());
        }
        if(clienteAtualizado.getDataNascimento() != null){
            clienteExistente.setDataNascimento(clienteAtualizado.getDataNascimento());
        }
        clienteRepository.save(clienteExistente);
    }
}
