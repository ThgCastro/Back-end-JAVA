package com.unip.crud.controller;

import com.unip.crud.model.Cliente;
import com.unip.crud.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public String listar(Model model){
        model.addAttribute("listaDeClientes", clienteService.findAllCliente());
        return "clientes";
    }

    @GetMapping("/novo")
    public String novoForm(Model model){
        model.addAttribute("cliente", new Cliente());
        return "cliente_form";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("cliente") Cliente cliente){
        clienteService.saveCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model){
        model.addAttribute("cliente",  clienteService.findClienteById(id));
        return "cliente_form";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id){
        clienteService.deleteClienteById(id);
        return "redirect:/clientes";
    }
}
