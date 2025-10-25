package com.unip.crud.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String complemento;
    private Integer cep;
    private String nomeLogradouro;
    private String cidade;
    private String estado;
    private Integer numero;

    @ManyToOne
    @JoinColumn(name = "Cliente_id")
    private Cliente cliente;

    public Endereco() {
    }

    public Endereco(Long id, String complemento, Integer cep, String nomeLogradouro, String cidade, String estado, Integer numero) {
        this.id = id;
        this.complemento = complemento;
        this.cep = cep;
        this.nomeLogradouro = nomeLogradouro;
        this.cidade = cidade;
        this.estado = estado;
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(id, endereco.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", endereco='" + nomeLogradouro + '\'' +
                ", cep=" + cep +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", cliente=" + cliente +
                '}';
    }
}
