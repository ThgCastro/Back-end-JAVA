package com.unip.crud.model.dao;

import com.unip.crud.model.Endereco;

import java.util.List;

public interface EnderecoDao {

    void criarEndereco();
    List<Endereco> viewEndereco(int idCliente);
}
