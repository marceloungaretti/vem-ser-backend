package com.dbc.pessoaapi.controller;


import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.dto.EnderecoDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
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



    @ApiOperation(value = "Cria um novo contato")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o contato criado com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @PostMapping("/{idPessoa}")
    public ContatoDTO create(@PathVariable("idPessoa") Integer idPessoa,
                             @RequestBody ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        return contatoService.create(idPessoa, contatoCreateDTO);
    }

    @ApiOperation(value = "Atualiza um contato pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o contato atualizado com sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @PutMapping("/{id}")
    public ContatoDTO update(@PathVariable("id") Integer id,
                                @RequestBody ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        return contatoService.update(id, contatoCreateDTO);
    }

    @ApiOperation(value = "Retorna uma lista de contatos")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de contatos"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping
    public List<ContatoDTO> list() {
        return contatoService.list();
    }

    // {{url}}/contato/1/pessoa
    @ApiOperation(value = "Busca os contatos da pessoa pelo id da pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o contato com sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping("/{idPessoa}/pessoa")
    public List<ContatoDTO> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) throws RegraDeNegocioException {
        return contatoService.getByIdPessoa(idPessoa);
    }

    // {{url}}/contato/1/contato
    @ApiOperation(value = "Busca um contato pelo id do contato")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o contato com sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping("/{idContato}/contato")
    public ContatoDTO getById(@RequestParam("idContato") Integer idContato) throws RegraDeNegocioException {
        return contatoService.getById(idContato);
    }

//    // {{url}}/contato/list-by-pessoas?idPessoa=1&nome=Maicon Machado
//    @ApiOperation(value = "Retorna uma lista de contatos por pessoas")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Retorna a lista de contatos por pessoa"),
//            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
//            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
//    })
//    @GetMapping("/list-by-pessoas")
//    public List<ContatoDTO> listByIdPessoaRequestParam(@RequestParam("idPessoa") Integer id,
//                                                          @RequestParam("nome") String nome) throws RegraDeNegocioException {
//        System.out.println(nome);
//        return contatoService.getByIdPessoa(id);
//    }

    @ApiOperation(value = "Delete um contato pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o contato deletado com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer idContato) throws RegraDeNegocioException {
        contatoService.delete(idContato);
    }
}