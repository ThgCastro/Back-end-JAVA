package com.unip.crud.controller;

import com.unip.crud.model.Cliente;
import com.unip.crud.model.dao.ClienteDao;
import com.unip.crud.model.dao.impl.ClienteDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ClienteController {

    @Autowired
    private ClienteDao clienteDao = new ClienteDaoImpl();

    public boolean createCliente(Cliente cliente){
        if(cliente == null){
            return false;
        }
        try{
            clienteDao.createCliente(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public List<Cliente> viewClientById(Long id){
        clienteDao.viewClienteById(id);
        return List.of();
    }

    publiv updateCliente(Long id, String newnome){
        clienteDao.updateClienteById(id, newnome);
        return null;
    }

    public boolean deleteClienteById(Long id) {
        try {
            clienteDao.deleteClienteById(id);
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
