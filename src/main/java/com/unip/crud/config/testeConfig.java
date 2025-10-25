package com.unip.crud.config;

import com.unip.crud.model.Cliente;
import com.unip.crud.model.Endereco;
import com.unip.crud.repositories.ClienteRepository;
import com.unip.crud.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
@Profile("teste")
public class testeConfig implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public void run(String... args) throws Exception {
        Cliente cli1 = new Cliente(null, "thiago1@gmail.com", LocalDate.parse("02-05-2005", fmt), LocalDate.parse("10-09-2003", fmt), "123456789", "Thiago");
        Endereco end1 = new Endereco(null, null, 40028922, "Rua da Paz", "São Paulo", "São Paulo", 123);
        Endereco end2 = new Endereco(null, "bloco 5", 303030, "Rua da Morte", "São Paulo", "São Paulo", 290);

        end1.setCliente(cli1);
        end2.setCliente(cli1);
        cli1.getEnderecos().add(end1);
        cli1.getEnderecos().add(end2);

        clienteRepository.saveAll(Arrays.asList(cli1));
        enderecoRepository.saveAll(Arrays.asList(end1, end2));
    }
}
