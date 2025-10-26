package com.unip.crud.controller;

import com.unip.crud.model.Endereco;
import com.unip.crud.services.ClienteService;
import com.unip.crud.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;
    private final ClienteService clienteService;

    public EnderecoController(EnderecoService enderecoService, ClienteService clienteService) {
        this.enderecoService = enderecoService;
        this.clienteService = clienteService;
    }

    @GetMapping("/cliente/{clienteId}")
    public String listarPorCliente(@PathVariable Long clienteId, Model model){
        model.addAttribute("cliente", clienteService.findClienteById(clienteId));
        model.addAttribute("listaDeEnderecos", enderecoService.findByClienteId(clienteId));
        return "enderecos";
    }

    @GetMapping("novo/{clienteId}")
    public String novoEnderecoForm(@PathVariable Long clienteId, Model model){
        Endereco endereco = new Endereco();
        endereco.setCliente(clienteService.findClienteById(clienteId));
        model.addAttribute("endereco", endereco);
        return "endereco_form";
    }

    @PostMapping("/salvar")
    public String salvarEndereco(@ModelAttribute("endereco") Endereco endereco){
        enderecoService.saveEndereco(endereco);
        return "redirect:/enderecos/cliente/" + endereco.getCliente().getId();
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id){
        Endereco endereco = enderecoService.findAllEndereco().stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
        Long clienteId = (endereco != null && endereco.getCliente() != null) ? endereco.getCliente().getId() : null;
        enderecoService.deleteEnderecoById(id);
        if(clienteId != null) return "redirect:/enderecos/cliente/" + clienteId;
        return "redirect:/clientes";
    }
}
