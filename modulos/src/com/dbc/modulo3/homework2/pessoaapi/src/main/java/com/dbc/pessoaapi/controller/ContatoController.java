package com.dbc.pessoaapi.controller;


import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.service.ContatoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {
    @Autowired
    private ContatoService contatoService;

    @ApiOperation(value = "Delete um contato pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o contato deletado com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        contatoService.delete(id);
    }

    @ApiOperation(value = "Cria um novo contato")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o contato criado com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @PostMapping("/{idPessoa}")
    public ContatoEntity create(@PathVariable("idPessoa") Integer idPessoa,
                                @RequestBody ContatoEntity contatoEntity) throws Exception {
        return contatoService.create(idPessoa, contatoEntity);
    }

    @ApiOperation(value = "Atualiza um contato pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o contato atualizado com sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @PutMapping("/{id}")
    public ContatoEntity update(@PathVariable("id") Integer id,
                                @RequestBody ContatoEntity contatoEntity) throws Exception {
        return contatoService.update(id, contatoEntity);
    }

    @ApiOperation(value = "Retorna uma lista de contatos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de contatos"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping
    public List<ContatoEntity> list() {
        return contatoService.list();
    }

    // {{url}}/contato/1/pessoa
    @ApiOperation(value = "Busca um contato pelo id da pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o contato com sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping("/{idPessoa}/pessoa")
    public List<ContatoEntity> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return contatoService.listByIdPessoa(idPessoa);
    }

    // {{url}}/contato/1/contato
    @ApiOperation(value = "Busca um contato pelo id do contato")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o contato com sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping("/{idContato}/contato")
    public ContatoEntity listByIdContato(@PathVariable("idContato") Integer idContato) throws Exception {
        return contatoService.listByIdContato(idContato);
    }

    // {{url}}/contato/list-by-pessoas?idPessoa=1&nome=Maicon Machado
    @ApiOperation(value = "Retorna uma lista de contatos por pessoas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de contatos por pessoa"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping("/list-by-pessoas")
    public List<ContatoEntity> listByIdPessoaRequestParam(@RequestParam("idPessoa") Integer id,
                                                          @RequestParam("nome") String nome) {
        System.out.println(nome);
        return contatoService.listByIdPessoa(id);
    }
}