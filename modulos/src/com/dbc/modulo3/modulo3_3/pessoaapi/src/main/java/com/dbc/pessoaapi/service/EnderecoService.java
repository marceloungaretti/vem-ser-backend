
package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.EnderecoCreateDTO;
import com.dbc.pessoaapi.dto.EnderecoDTO;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;

    private EnderecoEntity findById(Integer id) throws RegraDeNegocioException {
        EnderecoEntity entity = enderecoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("endereço não encontrado"));
        return entity;
    }

    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        pessoaRepository.findById(idPessoa);
        enderecoCreateDTO.setIdPessoa(idPessoa);

        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
        EnderecoEntity criar = enderecoRepository.save(enderecoEntity);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(criar, EnderecoDTO.class);
        return enderecoDTO;
    }

    public List<EnderecoDTO> list() {
        return enderecoRepository.findAll()
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO getById(Integer id) throws RegraDeNegocioException {
        EnderecoEntity entity = findById(id);
        return objectMapper.convertValue(entity, EnderecoDTO.class);
    }


//    public List<EnderecoDTO> getByIdPessoa(Integer idPessoa) throws RegraDeNegocioException {
//        pessoaRepository.findById(idPessoa);
//        return enderecoRepository.findById(idPessoa).stream()
//                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
//                .collect(Collectors.toList());
//    }


    public EnderecoDTO update(Integer idEndereco, EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        EnderecoEntity entity = objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
        entity.setIdEndereco(idEndereco);
        EnderecoEntity enderecoAtualizar = enderecoRepository.save(entity);
        return objectMapper.convertValue(enderecoAtualizar, EnderecoDTO.class);
    }


    public void delete(Integer id) throws RegraDeNegocioException {
        EnderecoEntity endereco = findById(id);
        enderecoRepository.delete(endereco);
    }

}