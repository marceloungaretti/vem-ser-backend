package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.entity.TipoContato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class ContatoRepository {
    public static List<ContatoEntity> contatosList = new ArrayList<>();
    private final AtomicInteger COUNTER = new AtomicInteger();

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostConstruct
    public void init(){
        List<PessoaEntity> pessoaEntities = pessoaRepository.list();
        contatosList.add(new ContatoEntity(COUNTER.incrementAndGet(), pessoaEntities.get(0).getIdPessoa(), TipoContato.COMERCIAL, "048995876566", "whatsapp"));
        contatosList.add(new ContatoEntity(COUNTER.incrementAndGet(), pessoaEntities.get(0).getIdPessoa(), TipoContato.RESIDENCIAL, "04833545655", "casa"));
        contatosList.add(new ContatoEntity(COUNTER.incrementAndGet(), pessoaEntities.get(1).getIdPessoa(), TipoContato.COMERCIAL, "051998654789", "trabalho"));
    }

    public void delete(Long id) throws Exception {
        ContatoEntity contatoEntity = contatosList.stream()
                .filter(x -> x.getIdContato() == id.longValue())
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não econtrado"));
        contatosList.remove(contatoEntity);
    }

    public ContatoEntity create(ContatoEntity contatoEntity) {
        contatoEntity.setIdContato(COUNTER.incrementAndGet());
        contatosList.add(contatoEntity);
        return contatoEntity;
    }

    public ContatoEntity update(Integer id, ContatoEntity contatoEntity) throws Exception {
        ContatoEntity contatoEntityAlterado = contatosList.stream()
                .filter(x -> x.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não econtrada"));
        contatoEntityAlterado.setTipoContato(contatoEntity.getTipoContato());
        contatoEntityAlterado.setNumero(contatoEntity.getNumero());
        contatoEntityAlterado.setDescricao(contatoEntity.getDescricao());
        return contatoEntityAlterado;
    }


    public List<ContatoEntity> list() {
        return contatosList;
    }

    public List<ContatoEntity> listByIdPessoa(Integer idPessoa) {
        return contatosList.stream()
                .filter(x -> x.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }

    public ContatoEntity listByIdContato(Integer idContato) throws Exception {
        return contatosList.stream()
                .filter(x -> x.getIdContato().equals(idContato))
                .findFirst()
                .orElseThrow(() -> new Exception("contato não encontrado"));
    }
}
