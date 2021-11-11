package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.*;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.dbc.pessoaapi.service.EnderecoService;
import com.dbc.pessoaapi.service.PessoaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/pessoa")
@Validated
@RequiredArgsConstructor
@Slf4j
public class PessoaController {
    private final PessoaService pessoaService;
    private final PessoaRepository pessoaRepository;

    @ApiOperation(value = "Cria uma nova pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a pessoa criada com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @PostMapping
    public PessoaDTO create(@RequestBody @Valid PessoaCreateDTO pessoaDTO)throws Exception{
        log.info("iniciando criação da pessoa");
        PessoaDTO pessoaEntityCriado = pessoaService.create(pessoaDTO);
        log.info("pessoa criada com sucesso!");
        return pessoaEntityCriado;
    }

    @ApiOperation(value = "Retorna uma lista de pessoas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de pessoas"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }


    @ApiOperation(value = "Retorna uma pessoa pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a pessoa com sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping("/{idPessoa}")
    public PessoaDTO getById(@RequestParam("idPessoa") Integer idPessoa) throws Exception {
        return pessoaService.getById(idPessoa);
    }


    @ApiOperation(value = "Atualiza uma pessoa pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a pessoa atualizada com sucesso"),
             @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @PutMapping("/{idPessoa}")
    public PessoaDTO update(@PathVariable("idPessoa") Integer id,
                            @RequestBody @Valid PessoaCreateDTO pessoaCreateDTO) throws Exception {
        return pessoaService.update(id, pessoaCreateDTO);
    }


    @ApiOperation(value = "Delete uma pessoa pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna pessoa deletada com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @DeleteMapping("/{idPessoa}")
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        pessoaService.delete(id);
    }

//    @GetMapping("nomeContem")
//    public List<PessoaEntity> nomesQueContem(@RequestParam("nome") String nome)  {
//        return pessoaRepository.findByNomeContainsIgnoreCase(nome);
//    }
//
//    @GetMapping("/buscacpf")
//    public PessoaEntity procuraPorCPF(@RequestParam("cpf") String cpf){
//        return pessoaRepository.findByCpf(cpf);
//    }
//
//    @GetMapping("nascidasEntre")
//    public List<PessoaEntity> procuraNascidas(@RequestParam("inicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicial,
//                                              @RequestParam("finale") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate finale){
//        return pessoaRepository.findByDataNascimentoBetween(inicial, finale);
//    }



    @ApiOperation(value = "Lista de Pessoas com Endereços por ID da Pessoa")
    @GetMapping("/listar-com-enderecos")
    public List<PessoaComEnderecoDTO> listaPessoasComEndereco(@RequestParam(required = false) Integer idPessoa) throws RegraDeNegocioException {

        return pessoaService.listaDePessoasEEnderecos(idPessoa);
    }

    @ApiOperation(value = "Lista de Pessoas com Contatos pelo ID da pessoa")
    @GetMapping("/listar-com-contatos")
    public List<PessoaComContatoDTO> listaPessoasComContato(@RequestParam(required = false) Integer idPessoa) throws RegraDeNegocioException {

        return pessoaService.listaDePessoasEContatos(idPessoa);
    }

    @ApiOperation(value = "Lista Pessoa com todos seus dados")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a pessoa com sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping("/pessoa-completo")
    public List<PessoaComTodosDadosDTO> listaContatosEnderecos(@RequestParam(required = false) Integer idPessoa) throws RegraDeNegocioException {
        return pessoaService.listaPessoaCompleto(idPessoa);

    }



    ///////////////////////////////////////////////////////////

    @ApiOperation(value = "Lista de Pessoas com Datas de Nascimento entre as seguintes datas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna as pessoas com sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping("/lista-data-entre")
    public List<PessoaEntity> findPessoasComNascimentoBetween(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                               LocalDate inicial,
                                                               @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                               LocalDate finale) {
        return pessoaRepository.findPessoasComNascimentoBetween(inicial, finale);
    }


    @ApiOperation(value = "Lista de pessoas que possuem endereço")
    @GetMapping("/pessoas-com-endereco")
    public List<PessoaEntity> findByExistingEndereco() {
        return pessoaRepository.findByExistingEndereco();
    }

    @ApiOperation(value = "(native)Lista de pessoas sem endereço")
    @GetMapping("/pessoas-sem-endereco")
    public List<PessoaEntity> findBySemEndereco() {
        return pessoaRepository.findBySemEndereco();
    }













}
