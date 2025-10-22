package com.unip.crud.controller;

import com.unip.crud.model.Endereco;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EnderecoController {

    public List<Endereco> criarEndereco(Endereco endereco){
        List<Endereco> enderecos = new ArrayList<>();
        return enderecos;
    }

    public List<Endereco> viewEnderecoById(Long id){
        List<Endereco> endereco = new ArrayList<>();
        return endereco;
    }
}
