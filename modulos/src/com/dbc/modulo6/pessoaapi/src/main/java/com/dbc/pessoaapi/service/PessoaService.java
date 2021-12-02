package com.dbc.pessoaapi.service;

import com.dbc.pessoaapi.dto.*;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.kafka.Producer;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService {
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;
    private final EmailService emailService;
    private final Producer producer;

    public void sendEmailPessoaSemEndereco() throws IOException {
        List<PessoaEntity> pessoasSemEndereco = pessoaRepository.findBySemEndereco();
        String message = "Estamos muito felizes que você está em nosso sistema." +
                "<br>Para que possamos enviá-lo um brinde exclusivo, por gentileza," +
                "<br>adicione ou atualize o seu endereço no seu cadastro.";
        for (PessoaEntity key : pessoasSemEndereco) {
            producer.sendMessage(new EmailDto(key.getNome(), key.getEmail(), "Atualize seu cadastro!", message));
        }
    }

    public void sendEmailXororo() throws MessagingException, TemplateException, IOException {
        List<PessoaEntity> pessoas = pessoaRepository.findAll();
        for (PessoaEntity key : pessoas) {
            String message = "Selecionamos algumas das nossas super promoções de natal na nossa plataforma" +
                    "<br>especialmente para você:" +
                    "<br>- Na compra de 1 CD do Chitãozinho e Xororó, ganhe 1 do Milionário e José Rico." +
                    "<br>- Na locação de um filme em VHS, a outra locação é grátis." +
                    "<br>- Fita de Super Nintendo com 50% de desconto.";
            producer.sendMessage(new EmailDto(key.getNome(), key.getEmail(), "Promoção de Natal!", message));
        }
    }

    public void sendAniversariante() throws JsonProcessingException {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM"));
        List<PessoaEntity> aniversariantes = pessoaRepository.searchAniversatiante(date);
        for (PessoaEntity key : aniversariantes) {
            String message = "Essa data de " + date + " também é especial" +
                    "<br>para nós do Vem Ser. Estamos comemorando junto com você. \\o/" +
                    "<br><br>Desejamos um feliz aniversário, que sejam " + (LocalDate.now().getYear() - key.getDataNascimento().getYear()) + " anos de muitos." +
                    "<br>Sucesso, alegria, felicidade e muitas realizações.";
            producer.sendMessage(new EmailDto(key.getNome(), key.getEmail(), "Parabéns!", message));
        }
    }

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
                .orElseThrow(() -> new RegraDeNegocioException("pessoa não encontrada"));
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
