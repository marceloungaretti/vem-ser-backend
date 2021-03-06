package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.*;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService {
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;

    public PessoaDTO create(PessoaCreateDTO pessoaCreateDTO) throws Exception {
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
        PessoaEntity pessoaCriada = pessoaRepository.save(pessoaEntity);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaCriada, PessoaDTO.class);
        return pessoaDTO;
    }

    public List<PessoaDTO> list() {
        return pessoaRepository.findAll()
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public PessoaDTO getById(Integer id) throws RegraDeNegocioException {
        PessoaEntity entity = findById(id);
        PessoaDTO dto = objectMapper.convertValue(entity, PessoaDTO.class);
        return dto;
    }


    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException {
        findById(id);
        PessoaEntity entity = objectMapper.convertValue(pessoaCreateDTO, PessoaEntity.class);
        entity.setIdPessoa(id);
        PessoaEntity update = pessoaRepository.save(entity);
        PessoaDTO dto = objectMapper.convertValue(update, PessoaDTO.class);
        return dto;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        PessoaEntity pessoa = findById(id);
        pessoaRepository.delete(pessoa);
    }

    private PessoaEntity findById(Integer id) throws RegraDeNegocioException {
        PessoaEntity entity = pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("pessoa n??o encontrada"));
        return entity;
    }

    public List<PessoaComEnderecoDTO> listaDePessoasEEnderecos(Integer idPessoa) throws RegraDeNegocioException {
        List<PessoaComEnderecoDTO> listaDePe = new ArrayList<>();

        if (idPessoa != null) {
            PessoaEntity pessoaBuscada = findById(idPessoa);
            var pessoaComEnderecoDTO = vinculaEnderecoPessoa(pessoaBuscada);
            listaDePe.add(pessoaComEnderecoDTO);
        } else {
            var pessoas = pessoaRepository.findAll();
            for (PessoaEntity pessoa : pessoas) {
                var pessoaComEnderecoDTO = vinculaEnderecoPessoa(pessoa);
                listaDePe.add(pessoaComEnderecoDTO);
            }
        }

        return listaDePe;
    }

    public List<PessoaComContatoDTO> listaDePessoasEContatos(Integer idPessoa) throws RegraDeNegocioException {
        List<PessoaComContatoDTO> listaDePe = new ArrayList<>();

        if (idPessoa != null) {
            PessoaEntity pessoaBuscada = findById(idPessoa);
            var pessoaComContatoDTO = vinculaContatoPessoa(pessoaBuscada);
            listaDePe.add(pessoaComContatoDTO);
        } else {
            var pessoas = pessoaRepository.findAll();
            for (PessoaEntity pessoa : pessoas) {
                var pessoaComContatoDTO = vinculaContatoPessoa(pessoa);
                listaDePe.add(pessoaComContatoDTO);
            }
        }

        return listaDePe;
    }

    public List<PessoaComTodosDadosDTO> listaContatosEnderecos(Integer idPessoa) throws RegraDeNegocioException {
        List<PessoaComTodosDadosDTO> listaDePe = new ArrayList<>();

        if (idPessoa != null) {
            PessoaEntity pessoaBuscada = findById(idPessoa);
            var pessoaCompletaDTO = vinculaTudo(pessoaBuscada);
            listaDePe.add(pessoaCompletaDTO);
        } else {
            var pessoas = pessoaRepository.findAll();
            for (PessoaEntity pessoa : pessoas) {
                var pessoaCompletaDTO = vinculaTudo(pessoa);
                listaDePe.add(pessoaCompletaDTO);
            }
        }

        return listaDePe;
    }

    private PessoaComTodosDadosDTO vinculaTudo(PessoaEntity pessoaEntity) {
        var pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaComTodosDadosDTO.class);
        pessoaDTO.setContatos(pessoaEntity.getContatos().stream()
                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class)).collect(Collectors.toSet()));
        pessoaDTO.setEnderecos(pessoaEntity.getEnderecos().stream()
                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class)).collect(Collectors.toSet()));

        pessoaDTO.setIdPessoa(pessoaEntity.getIdPessoa());
        return pessoaDTO;
    }

    private PessoaComContatoDTO vinculaContatoPessoa(PessoaEntity pessoaEntity) {
        PessoaComContatoDTO pessoaComContatoDTO = objectMapper.convertValue(pessoaEntity, PessoaComContatoDTO.class);
        pessoaComContatoDTO.setContatos(pessoaEntity.getContatos().stream()
                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class)).collect(Collectors.toSet()));

        pessoaComContatoDTO.setIdPessoa(pessoaEntity.getIdPessoa());
        return pessoaComContatoDTO;
    }

    private PessoaComEnderecoDTO vinculaEnderecoPessoa(PessoaEntity pessoaEntity) {
        PessoaComEnderecoDTO pessoaComEnderecoDTO = objectMapper.convertValue(pessoaEntity, PessoaComEnderecoDTO.class);
        pessoaComEnderecoDTO.setEnderecos(pessoaEntity.getEnderecos().stream()
                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class)).collect(Collectors.toSet()));

        pessoaComEnderecoDTO.setIdPessoa(pessoaEntity.getIdPessoa());
        return pessoaComEnderecoDTO;
    }

    public List<PessoaComTodosDadosDTO> listaPessoaCompleto(Integer idPessoa) throws RegraDeNegocioException {
        List<PessoaEntity> listaPessoasEntity = pessoaRepository.findAll();
        List<PessoaComTodosDadosDTO> listaPessoaComTodosDados = new ArrayList<>();

        if (idPessoa == null) {
            for(PessoaEntity pessoa: listaPessoasEntity) {
                PessoaComTodosDadosDTO pessoaComTodosDadosDTO = objectMapper.convertValue(pessoa,PessoaComTodosDadosDTO.class);
                pessoaComTodosDadosDTO.setContatos(pessoa.getContatos().stream().
                        map(contatoEntity -> {
                            ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntity, ContatoDTO.class);
                            contatoDTO.setIdPessoa(pessoa.getIdPessoa());
                            return contatoDTO;
                        })
                        .collect(Collectors.toSet()));

                pessoaComTodosDadosDTO.setEnderecos(pessoa.getEnderecos().stream().
                        map(enderecoEntity -> {
                            EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
                            enderecoDTO.setIdPessoa(pessoa.getIdPessoa());
                            return enderecoDTO;
                        })
                        .collect(Collectors.toSet()));

                listaPessoaComTodosDados.add(pessoaComTodosDadosDTO);
            }

            return listaPessoaComTodosDados;
        }

        PessoaEntity pessoaEntity = findById(idPessoa);
        PessoaComTodosDadosDTO pessoaComTodosDadosDTO = objectMapper.convertValue(pessoaEntity, PessoaComTodosDadosDTO.class);
        pessoaComTodosDadosDTO.setContatos(pessoaEntity.getContatos().stream().
                map(contatoEntity -> {
                    ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntity, ContatoDTO.class);
                    contatoDTO.setIdPessoa(idPessoa);
                    return contatoDTO;
                })
                .collect(Collectors.toSet()));

        pessoaComTodosDadosDTO.setEnderecos(pessoaEntity.getEnderecos().stream().
                map(enderecoEntity -> {
                    EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
                    enderecoDTO.setIdPessoa(idPessoa);
                    return enderecoDTO;
                })
                .collect(Collectors.toSet()));

        listaPessoaComTodosDados.add(pessoaComTodosDadosDTO);

        return listaPessoaComTodosDados;

    }




}
