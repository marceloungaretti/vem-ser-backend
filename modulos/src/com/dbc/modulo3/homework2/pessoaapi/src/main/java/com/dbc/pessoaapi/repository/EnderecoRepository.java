package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.Endereco;
import com.dbc.pessoaapi.entity.TipoEndereco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {
    private static List<Endereco> listaEnderecos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoRepository() {
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(),1, TipoEndereco.RESIDENCIAL,
                "Rua das Árvores", 12, "apto 201", "90625558",
                "Barueri", "São Paulo","Brasil" ));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(),90, TipoEndereco.RESIDENCIAL,
                "Rua das Abóboras", 12, "casa", "90235358",
                "São Gonçalo", "Rio de Janeiro","Brasil" ));
    }

    public List<Endereco> list() {
        return listaEnderecos;
    }

    public List<Endereco> listByIdEndereco(Integer idEndereco) {
        return listaEnderecos.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .collect(Collectors.toList());
    }

    public List<Endereco> listByIdPessoa(Integer idPessoa) {
        return listaEnderecos.stream()
                .filter(endereco -> endereco.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }

    public Endereco create(Endereco endereco) {
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        listaEnderecos.add(endereco);
        return endereco;
    }

    public Endereco update(Integer idEndereco, Endereco enderecoAtualizar) throws Exception {
        Endereco enderecoRecuperado = listaEnderecos.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereço não encontrado"));
        enderecoRecuperado.setIdPessoa(enderecoAtualizar.getIdPessoa());
        enderecoRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setEstado(enderecoAtualizar.getEstado());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais());
        return enderecoRecuperado;
    }

    public void delete(Integer idEndereco) throws Exception {
        Endereco enderecoRecuperado = listaEnderecos.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereço não encontrado"));
        listaEnderecos.remove(enderecoRecuperado);
    }
}
