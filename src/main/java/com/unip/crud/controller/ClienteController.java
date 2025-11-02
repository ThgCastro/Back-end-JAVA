package com.unip.crud.controller;

import com.unip.crud.model.Cliente;
import com.unip.crud.model.Endereco;
import com.unip.crud.services.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

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
        Cliente cliente = new Cliente();
        cliente.getEnderecos().add(new Endereco());
        model.addAttribute("cliente", cliente);
        return "cadastrar";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute("cliente") Cliente cliente, @RequestParam(value = "clienteId", required = false) Long clienteId){
        if(clienteId != null){
            Cliente clienteExistente = clienteService.findClienteById(clienteId);
            for (Endereco e : cliente.getEnderecos()) {
                e.setCliente(clienteExistente);
            }
            clienteExistente.getEnderecos().addAll(cliente.getEnderecos());
            clienteService.saveCliente(clienteExistente);
        } else{
            for(Endereco e :  cliente.getEnderecos()){
                e.setCliente(cliente);
            }
            clienteService.saveCliente(cliente);
        }
        return "redirect:/clientes";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Long id, Model model){
        model.addAttribute("cliente",  clienteService.findClienteById(id));
        return "editarCliente";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id){
        clienteService.deleteClienteById(id);
        return "redirect:/clientes";
    }
}
