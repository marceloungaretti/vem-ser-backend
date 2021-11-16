package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.dbc.pessoaapi.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paginacao")
@RequiredArgsConstructor
public class PaginacaoController {

    private final PessoaRepository pessoaRepository;
    private final ContatoRepository contatoRepository;
    private final EnderecoRepository enderecoRepository;

    @GetMapping("/lista-paginada")
    public Page<PessoaEntity> listaPaginada(
        @RequestParam Integer pagina,
        @RequestParam Integer quantidadeDeRegistrosPorPagina
    ){
        Pageable pageable = PageRequest.of(pagina, quantidadeDeRegistrosPorPagina);
        Page<PessoaEntity> paginaDoBanco = pessoaRepository.findAll(pageable);
        return paginaDoBanco;
    }


    @GetMapping("/lista-ordenada")
    public Page<PessoaEntity> listaPaginadaOrdenada(
            @RequestParam Integer pagina,
            @RequestParam Integer quantidadeDeRegistrosPorPagina
    ){
        Pageable pageable = PageRequest.of(pagina, quantidadeDeRegistrosPorPagina, Sort.by("cpf").and(Sort.by("nome")));
        Page<PessoaEntity> paginaDoBanco = pessoaRepository.findAll(pageable);
        return paginaDoBanco;
    }


    @GetMapping("/lista-nomejpql")
    public Page<PessoaEntity> listaPaginada(
            @RequestParam Integer pagina,
            @RequestParam String nome,
            @RequestParam Integer quantidadeDeRegistrosPorPagina
    ){
        Pageable pageable = PageRequest.of(pagina, quantidadeDeRegistrosPorPagina);
        Page<PessoaEntity> paginaDoBanco = pessoaRepository.findByNomeJPQL("%"+nome+"%", pageable);
        return paginaDoBanco;
    }

    @GetMapping("/lista-contatos-ordenados")
    public Page<ContatoEntity> listaPorContatosPorDescricao(
            @RequestParam Integer pagina,
            @RequestParam Integer quantidadeDeRegistrosPorPagina
    ){
        Pageable pageable = PageRequest.of(pagina, quantidadeDeRegistrosPorPagina, Sort.by("descricao"));
        return contatoRepository.findAll(pageable);
    }

    @GetMapping("/lista-enderecos-ordenados")
    public Page<EnderecoEntity> listaPorEnderecosPorCep(
            @RequestParam Integer pagina,
            @RequestParam Integer quantidadeDeRegistrosPorPagina
    ){
        Pageable pageable = PageRequest.of(pagina, quantidadeDeRegistrosPorPagina, Sort.by("cep"));
        return enderecoRepository.findAll(pageable);
    }

    @GetMapping("/lista-enderecos-por-pais")
    public Page<EnderecoEntity> listaPorEnderecosPorPais(
            @RequestParam Integer pagina,
            @RequestParam Integer quantidadeDeRegistrosPorPagina,
            @RequestParam String pais
    ){
        Pageable pageable = PageRequest.of(pagina, quantidadeDeRegistrosPorPagina);
        return enderecoRepository.paginarEnderecosPorPais("%"+pais+"%", pageable);
    }



}
