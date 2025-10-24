package com.unip.crud.services;

import com.unip.crud.model.Cliente;
import com.unip.crud.repositories.ClienteRepository;
import com.unip.crud.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public void saveCliente(Cliente cliente){
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
        if(clienteAtualizado.getEmail() != null){
            clienteExistente.setEmail(clienteAtualizado.getEmail());
        }
        if(clienteAtualizado.getDataNascimento() != null){
            clienteExistente.setDataNascimento(clienteAtualizado.getDataNascimento());
        }
        clienteRepository.saveAndFlush(clienteAtualizado);
    }
}
