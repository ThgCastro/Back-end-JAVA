package com.unip.crud.controller;

import com.unip.crud.model.Endereco;
import com.unip.crud.services.ClienteService;
import com.unip.crud.services.EnderecoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;
    private final ClienteService clienteService;

    public EnderecoController(EnderecoService enderecoService, ClienteService clienteService) {
        this.enderecoService = enderecoService;
        this.clienteService = clienteService;
    }

    @GetMapping
    public String listar(Model model){
        model.addAttribute("listaDeEnderecos", enderecoService.findAllEndereco());
        return "enderecos";
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
        return "editarEndereco";
    }

    @PostMapping("/salvar")
    public String salvarEndereco(@ModelAttribute("endereco") Endereco endereco){
        enderecoService.saveEndereco(endereco);
        return "redirect:/enderecos";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id){
        Endereco endereco = enderecoService.findAllEndereco().stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
        Long clienteId = (endereco != null && endereco.getCliente() != null) ? endereco.getCliente().getId() : null;
        enderecoService.deleteEnderecoById(id);
        if(clienteId != null) return "redirect:/enderecos/cliente/" + clienteId;
        return "redirect:/clientes";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model){
        Endereco endereco = enderecoService.findEnderecoById(id);
        model.addAttribute("endereco", endereco);
        return "editarEndereco";
    }
}
