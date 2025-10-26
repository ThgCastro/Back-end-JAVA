package com.unip.crud.controller;

import com.unip.crud.model.Cliente;
import com.unip.crud.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Void> createCliente(@RequestBody Cliente cliente){
        clienteService.createCliente(cliente);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/")
    public String findAllCliente(Model model){
        model.addAttribute("clientes",clienteService.findAllCliente());
        return "allClientes";
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> findClienteById(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.findClienteById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClienteById(@PathVariable Long id) {
        clienteService.deleteClienteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateClienteById(@PathVariable Long id, @RequestBody Cliente cliente){
        clienteService.updateClienteById(id, cliente);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/novo")
    public String mostrarFormulario(Model model){
        model.addAttribute("cliente", new Cliente());
        return "formCliente";
    }

    @PostMapping("/salvar")
    public String salvarCliente(@ModelAttribute Cliente cliente){
        clienteService.salvarClienteEndereco(cliente);
        return "redirect:/clientes/novo";
    }
}
