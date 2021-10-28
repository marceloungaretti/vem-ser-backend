package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.entity.TipoContato;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;


    public Contato create(Contato contato) throws Exception {
        pessoaRepository.validarPessoa(contato.getIdPessoa());

        if(contato.getTipoContato() != TipoContato.COMERCIAL && contato.getTipoContato() != TipoContato.RESIDENCIAL){
            throw new RegraDeNegocioException("O campo Tipo Contato não é válido");
        }
        if(ObjectUtils.isEmpty(contato.getNumero())){
            throw new Exception("O campo número não pode estar vazio");
        }
        if(StringUtils.length(contato.getNumero()) > 13) {
            throw new Exception("O campo número não pode ter mais de 13 caracteres");
        }
        if(StringUtils.isEmpty(contato.getDescricao())) {
            throw new Exception("O campo descrição não pode estar vazio");
        }
        return contatoRepository.create(contato);
    }

    public List<Contato> list(){
        return contatoRepository.list();
    }

    public Contato update(Integer id,
                         Contato contatoAtualizar) throws Exception {
        pessoaRepository.validarPessoa(contatoAtualizar.getIdPessoa());
        return contatoRepository.update(id, contatoAtualizar);
    }

    public void delete(Integer id) throws Exception {
        contatoRepository.delete(id);
    }

    public List<Contato> listByIdPessoa(Integer id){
        return contatoRepository.listByIdPessoa(id);
    }

}
