package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContatoService {
    private final ContatoRepository contatoRepository;
    private final PessoaRepository pessoaRepository;

    public void delete(Long id) throws Exception {
        contatoRepository.delete(id);
    }

    public ContatoEntity create(Integer idPessoa, ContatoEntity contatoEntity) throws Exception {
        PessoaEntity pessoaEntity = pessoaRepository.list().stream()
                .filter(x -> x.getIdPessoa().equals(idPessoa))
                .findFirst().orElseThrow(() -> new Exception("Pessoa não encontrada"));
        contatoEntity.setIdPessoa(pessoaEntity.getIdPessoa());
        return contatoRepository.create(contatoEntity);
    }

    public ContatoEntity update(Integer id, ContatoEntity contatoEntity) throws Exception {
        return contatoRepository.update(id, contatoEntity);
    }


    public List<ContatoEntity> list() {
        return contatoRepository.list();
    }

    public List<ContatoEntity> listByIdPessoa(Integer idPessoa) {
        return contatoRepository.listByIdPessoa(idPessoa);
    }

    public ContatoEntity listByIdContato(Integer idContato) throws Exception {
        return contatoRepository.listByIdContato(idContato);
    }
}
