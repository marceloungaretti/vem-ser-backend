package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.TipoEndereco;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class EnderecoRepository {
    public static List<EnderecoEntity> enderecoEntities = new ArrayList<>();
    private final AtomicInteger COUNTER = new AtomicInteger();

    @PostConstruct
    public void init() {
        enderecoEntities.add(new EnderecoEntity(COUNTER.incrementAndGet(), 1, TipoEndereco.RESIDENCIAL, "Rua João da silva Um", 4156, "apto 506", "89999555", "Florianópolis", "SC", "Brasil"));
        enderecoEntities.add(new EnderecoEntity(COUNTER.incrementAndGet(), 1, TipoEndereco.COMERCIAL, "Rua José dos Santos Dois", 123, "sala 2", "85965656", "Porto Alegre", "RS", "Brasil"));
        enderecoEntities.add(new EnderecoEntity(COUNTER.incrementAndGet(), 2, TipoEndereco.RESIDENCIAL, "Rua Luiz da Silva Três", 456, "casa", "89999555", "Porto Alegre", "RS", "Brasil"));
    }

    public List<EnderecoEntity> list() {
        return enderecoEntities;
    }

    public List<EnderecoEntity> listByIdPessoa(Integer idPessoa) {
        return enderecoEntities.stream()
                .filter(x -> x.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }

    public EnderecoEntity findById(Integer idEndereco) throws Exception {
        return enderecoEntities.stream()
                .filter(x -> x.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new Exception("endereco não encontrado"));
    }

    public EnderecoEntity create(EnderecoEntity enderecoEntity) {
        enderecoEntity.setIdEndereco(COUNTER.incrementAndGet());
        enderecoEntities.add(enderecoEntity);
        return enderecoEntity;
    }

    public EnderecoEntity update(Integer idEndereco, EnderecoEntity enderecoEntityAtualizar) throws RegraDeNegocioException {
        EnderecoEntity enderecoEntityProcurar = enderecoEntities.stream()
                .filter(enderecoEntity -> enderecoEntity.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereco não localizado"));
        enderecoEntityProcurar.setTipo(enderecoEntityAtualizar.getTipo());
        enderecoEntityProcurar.setLogradouro(enderecoEntityAtualizar.getLogradouro());
        enderecoEntityProcurar.setNumero(enderecoEntityAtualizar.getNumero());
        enderecoEntityProcurar.setComplemento(enderecoEntityAtualizar.getComplemento());
        enderecoEntityProcurar.setCep(enderecoEntityAtualizar.getCep());
        enderecoEntityProcurar.setCidade(enderecoEntityAtualizar.getCidade());
        enderecoEntityProcurar.setEstado(enderecoEntityAtualizar.getEstado());
        enderecoEntityProcurar.setPais(enderecoEntityAtualizar.getPais());

        return enderecoEntityProcurar;
    }

    public void delete(Integer id) throws Exception {
        EnderecoEntity enderecoEntity = enderecoEntities.stream()
                .filter(x -> x.getIdEndereco() == id.longValue())
                .findFirst()
                .orElseThrow(() -> new Exception("endereço não econtrado"));
        enderecoEntities.remove(enderecoEntity);
    }
}