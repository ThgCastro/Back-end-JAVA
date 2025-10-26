package com.unip.crud.services;

import com.unip.crud.model.Endereco;
import com.unip.crud.repositories.EnderecoRepository;
import com.unip.crud.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;


    public List<Endereco> findAllEndereco(){
        return enderecoRepository.findAll();
    }

    public Endereco findEnderecoById(Long id){
        Optional<Endereco> obj = enderecoRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<Endereco> findByClienteId(Long clienteId){
        return enderecoRepository.findByClienteId(clienteId);
    }

    public Endereco saveEndereco(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public void deleteEnderecoById(Long id){
        enderecoRepository.deleteById(id);
    }
}
