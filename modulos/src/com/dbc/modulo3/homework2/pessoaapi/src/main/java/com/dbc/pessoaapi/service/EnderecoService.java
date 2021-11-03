
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

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;

    public List<EnderecoDTO> list() {
        return enderecoRepository.list().stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> listByIdPessoa(Integer idPessoa) throws RegraDeNegocioException {
        pessoaRepository.buscarPorId(idPessoa);
        return enderecoRepository.listByIdPessoa(idPessoa).stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO findById(Integer idEndereco) throws Exception {
        EnderecoEntity enderecoEntity = enderecoRepository.findById(idEndereco);

        return objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
    }

    public EnderecoDTO create(Integer idPessoa, @Valid EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        pessoaRepository.buscarPorId(idPessoa);
        enderecoCreateDTO.setIdPessoa(idPessoa);

        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
        EnderecoEntity criar = enderecoRepository.create(enderecoEntity);

        EnderecoDTO enderecoDTO = objectMapper.convertValue(criar, EnderecoDTO.class);
        return enderecoDTO;
    }

    public EnderecoDTO update(Integer idEndereco, EnderecoCreateDTO enderecoCreateDTO) throws Exception {
        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
        EnderecoEntity atualizado = enderecoRepository.update(idEndereco, enderecoEntity);

        EnderecoDTO enderecoDTO = objectMapper.convertValue(atualizado, EnderecoDTO.class);

        return enderecoDTO;
    }

    public void delete(Integer id) throws Exception {
        enderecoRepository.delete(id);
    }
}