package com.dbc.pessoaapi.controller;


import com.dbc.pessoaapi.dto.ContatoCreateDTO;
import com.dbc.pessoaapi.dto.ContatoDTO;
import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.TipoContato;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.ContatoRepository;
import com.dbc.pessoaapi.service.ContatoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
@RequiredArgsConstructor
public class ContatoController {

    private final ContatoService contatoService;
    private final ContatoRepository contatoRepository;



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
    @GetMapping("/{idPessoa}")
    List<ContatoEntity> listContatosPorIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return contatoRepository.listContatosPorIdPessoa(idPessoa);
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

    //corrigir
//    @ApiOperation(value = "Lista os contatos por seu tipo")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Retorna os contatos com sucesso"),
//            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
//    })
//    @GetMapping("/contatos-por-tipo")
//    List<ContatoEntity> listContatosPorTipoContato(@RequestParam("tipoContato") Integer tipoContato) {
//        return contatoRepository.listContatosPorTipo(tipoContato);
//    }
}