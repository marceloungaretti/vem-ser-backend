package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;

    public void delete(Long id) throws Exception {
        enderecoRepository.delete(id);
    }

    public EnderecoEntity create(Integer idPessoa, EnderecoEntity enderecoEntity) {
        enderecoEntity.setIdPessoa(idPessoa);
        return enderecoRepository.create(enderecoEntity);
    }

    public EnderecoEntity update(Integer id, EnderecoEntity enderecoEntity) throws Exception {
        return enderecoRepository.update(id, enderecoEntity);
    }


    public List<EnderecoEntity> list() {
        return enderecoRepository.list();
    }

    public List<EnderecoEntity> listByIdPessoa(Integer idPessoa) {
        return enderecoRepository.listByIdPessoa(idPessoa);
    }

    public EnderecoEntity findById(Integer idEndereco) throws Exception {
        return enderecoRepository.findById(idEndereco);
    }
}
