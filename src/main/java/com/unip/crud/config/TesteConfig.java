/*package com.unip.crud.config;

import com.unip.crud.model.Cliente;
import com.unip.crud.model.Endereco;
import com.unip.crud.repositories.ClienteRepository;
import com.unip.crud.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.xml.stream.events.Comment;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
@Profile("teste")
public class TesteConfig implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public void run(String... args) throws Exception {

        Cliente cli1 = new Cliente(null, LocalDate.parse("01-01-2000", dtf), "123456789", "João Silva");
        Cliente cli2 = new Cliente(null, LocalDate.parse("20-12-1985" ,dtf), "987654321", "Maria Souza");


        Endereco end1 = new Endereco(null, null, 40028922, "Rua da Paz", "São Paulo", "São Paulo", 123);
        Endereco end2 = new Endereco(null, "bloco 5", 30303090, "Rua da Morte", "São Paulo", "São Paulo", 290);
        Endereco end3 = new Endereco(null, "Apto 10", 90876437, "Rua Das Flores", "São Paulo", "São Paulo", 128);

        end1.setCliente(cli1);
        end2.setCliente(cli1);
        end3.setCliente(cli2);

        cli1.getEnderecos().add(end1);
        cli1.getEnderecos().add(end2);
        cli2.getEnderecos().add(end3);

        clienteRepository.saveAll(Arrays.asList(cli1, cli2));
        enderecoRepository.saveAll(Arrays.asList(end1, end2, end3));
    }
}
*/