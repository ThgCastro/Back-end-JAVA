package com.unip.crud.model.dao.impl;

import com.unip.crud.model.Cliente;
import com.unip.crud.model.dao.ClienteDao;

import java.util.ArrayList;
import java.util.List;

public class ClienteDaoImpl implements ClienteDao {

    @Override
    public void createCliente(Cliente c) {
        try{

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Cliente> viewCliente() {
        List<Cliente> list = new ArrayList<>();
        return list;
    }

    @Override
    public void updateCliente(Long id, String newNome) {
        try {

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCliente(Long id) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
