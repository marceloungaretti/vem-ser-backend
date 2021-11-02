package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.TipoEndereco;
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
        enderecoEntities.add(new EnderecoEntity(COUNTER.incrementAndGet(), 1, TipoEndereco.RESIDENCIAL, "Rua Pedro José", 4156, "casa", "89999555", "Florianópolis", "SC", "Brasil"));
        enderecoEntities.add(new EnderecoEntity(COUNTER.incrementAndGet(), 1, TipoEndereco.COMERCIAL, "Rua José dos Santos", 123, "sala 25", "85965656", "Porto Alegre", "RS", "Brasil"));
        enderecoEntities.add(new EnderecoEntity(COUNTER.incrementAndGet(), 2, TipoEndereco.RESIDENCIAL, "Rua Leopoldo Faguntes", 456, "casa", "89999555", "Porto Alegre", "RS", "Brasil"));
    }

    public void delete(Long id) throws Exception {
        EnderecoEntity enderecoEntity = enderecoEntities.stream()
                .filter(x -> x.getIdEndereco() == id.longValue())
                .findFirst()
                .orElseThrow(() -> new Exception("endereço não econtrado"));
        enderecoEntities.remove(enderecoEntity);
    }

    public EnderecoEntity create(EnderecoEntity enderecoEntity) {
        enderecoEntity.setIdEndereco(COUNTER.incrementAndGet());
        enderecoEntities.add(enderecoEntity);
        return enderecoEntity;
    }

    public EnderecoEntity update(Integer id, EnderecoEntity enderecoEntity) throws Exception {
        EnderecoEntity enderecoEntityAlterado = enderecoEntities.stream()
                .filter(x -> x.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("endereço não econtrado"));
        enderecoEntityAlterado.setTipo(enderecoEntity.getTipo());
        enderecoEntityAlterado.setLogradouro(enderecoEntity.getLogradouro());
        enderecoEntityAlterado.setNumero(enderecoEntity.getNumero());
        enderecoEntityAlterado.setComplemento(enderecoEntity.getComplemento());
        enderecoEntityAlterado.setCep(enderecoEntity.getCep());
        enderecoEntityAlterado.setCidade(enderecoEntity.getCep());
        enderecoEntityAlterado.setEstado(enderecoEntity.getEstado());
        enderecoEntityAlterado.setPais(enderecoEntity.getPais());
        return enderecoEntityAlterado;
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
}
