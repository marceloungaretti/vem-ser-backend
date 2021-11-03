package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.service.EmailService;
import com.dbc.pessoaapi.service.PessoaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.dbc.pessoaapi.service.EmailService;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
@Validated
@RequiredArgsConstructor
@Slf4j
public class PessoaController {
    private final PessoaService pessoaService;
    private EmailService emailService;

    private String name;

//    @GetMapping("/hello")
//    public ResponseEntity<String> hello() {
//        log.trace("A TRACE Message");
//        log.debug("A DEBUG Message");
//        log.info("A INFO Message");
//        log.warn("A WARN Message");
//        log.error("An ERROR Message");
//        return new ResponseEntity<>(name, HttpStatus.ACCEPTED);
//    }

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

    @ApiOperation(value = "Busca uma pessoa pelo seu nome")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a pessoa buscada com sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping("/byname")
    public List<PessoaDTO> listByName(@RequestParam("nome") @NotEmpty(message = "nome da pessoa não informado") String nome) {
        return pessoaService.listByName(nome);
    }


    @ApiOperation(value = "Atualiza uma pessoa pelo seu nome")
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
}
