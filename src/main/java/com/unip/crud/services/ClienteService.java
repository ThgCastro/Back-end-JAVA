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


    public void createCliente(Cliente cliente){
        clienteRepository.save(cliente);
    }

    public List<Cliente> findAllCliente(){
        return (List<Cliente>) clienteRepository.findAll();
    }

    public Cliente findClienteById(Long id){
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional
    public void deleteClienteById (Long id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente nao encontrado"));
        enderecoRepository.deleteAll(cliente.getEnderecos());
        clienteRepository.delete(cliente);
    }

    @Transactional
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

    public Cliente salvarClienteEndereco(Cliente cliente){
        for(Endereco e: cliente.getEnderecos()){
            e.setCliente(cliente);
        }
        return clienteRepository.save(cliente);
    }
}
