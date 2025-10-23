package com.unip.crud.controller;

import com.unip.crud.model.Cliente;
import com.unip.crud.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Void> saveCliente(@RequestBody Cliente cliente){
        clienteService.saveCliente(cliente);
        return ResponseEntity.ok().build();
    }

    public boolean deleteClienteById(Long id) {
        if(id == null){
            return false;
        }
        return true;
    }

    @PostMapping()
    public void updateClienteById(Long id, Cliente clienteAtualizado){
        clienteService.updateClienteById(id, clienteAtualizado);
    }
}
