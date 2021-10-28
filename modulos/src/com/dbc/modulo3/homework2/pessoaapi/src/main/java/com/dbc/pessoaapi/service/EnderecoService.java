package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.entity.Endereco;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;


    private void validarEndereco(Integer idEndereco) throws RegraDeNegocioException {
        if(enderecoRepository.listByIdEndereco(idEndereco).size() == 0) {
            throw new RegraDeNegocioException("O endereço não existe");
        }
    }

    public Endereco create(Endereco endereco) throws RegraDeNegocioException {
        pessoaRepository.validarPessoa(endereco.getIdPessoa());
        return enderecoRepository.create(endereco);
    }

    public List<Endereco> list() {
        return enderecoRepository.list();
    }

    public List<Endereco> listByIdEndereco(Integer idEndereco) {
        return enderecoRepository.listByIdEndereco(idEndereco);
    }

    public List<Endereco> listByIdPessoa(Integer idPessoa) {
        return enderecoRepository.listByIdPessoa(idPessoa);
    }

    public Endereco update(Integer idEndereco, Endereco enderecoAtualizar) throws Exception {
        pessoaRepository.validarPessoa(enderecoAtualizar.getIdPessoa());
        return enderecoRepository.update(idEndereco, enderecoAtualizar);
    }

    public void delete(Integer idEndereco) throws Exception {
        this.validarEndereco(idEndereco);
        enderecoRepository.delete(idEndereco);
    }
}
