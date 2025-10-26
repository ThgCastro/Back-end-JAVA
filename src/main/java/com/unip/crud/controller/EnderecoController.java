package com.unip.crud.controller;

import com.unip.crud.model.Endereco;
import com.unip.crud.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Void> createEndereco(@RequestBody Endereco endereco){
        enderecoService.createEndereco(endereco);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Endereco> findAllEndereco(){
        return enderecoService.findAllEndereco();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Endereco> findEnderecoById(@PathVariable Long id){
        return ResponseEntity.ok(enderecoService.findEnderecoById(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteEnderecoById(@PathVariable Long id){
        enderecoService.deleteEndereco(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEnderecoById(@PathVariable Long id, @RequestBody Endereco endereco){
        enderecoService.updateEnderecoById(id, endereco);
        return ResponseEntity.ok().build();
    }
}
