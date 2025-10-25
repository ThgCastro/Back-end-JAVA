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

    public void createEndereco(Endereco endereco){
        enderecoRepository.save(endereco);
    }

    public List<Endereco> findAllEndereco(){
        return enderecoRepository.findAll();
    }

    public Endereco findEnderecoById(Long id){
        Optional<Endereco> obj = enderecoRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void deleteEnderecoById(Long id){
        enderecoRepository.deleteById(id);
    }

    public void updateEnderecoById(Long id, Endereco enderecoAtualizado){
        Endereco enderecoExistente = enderecoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

        if(enderecoAtualizado.getNomeLogradouro() != null){
            enderecoExistente.setNomeLogradouro(enderecoAtualizado.getNomeLogradouro());
        }
        if(enderecoAtualizado.getComplemento() != null){
            enderecoExistente.setComplemento(enderecoAtualizado.getComplemento());
        }
        if(enderecoAtualizado.getNumero() != null){
            enderecoExistente.setNumero(enderecoAtualizado.getNumero());
        }
        if(enderecoAtualizado.getCep() != null){
            enderecoExistente.setCep(enderecoAtualizado.getCep());
        }
        if(enderecoAtualizado.getCidade() != null){
            enderecoExistente.setCidade(enderecoAtualizado.getCidade());
        }
        if(enderecoAtualizado.getEstado() != null){
            enderecoExistente.setEstado(enderecoAtualizado.getEstado());
        }
        enderecoRepository.save(enderecoExistente);
    }
}
