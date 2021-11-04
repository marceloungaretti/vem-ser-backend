
package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.EnderecoCreateDTO;
import com.dbc.pessoaapi.dto.EnderecoDTO;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.service.EnderecoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/endereco")
@RequiredArgsConstructor
@Slf4j
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @ApiOperation(value = "Cria um novo endereço para uma pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o endereço criado com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @PostMapping("/{idPessoa}")
    public EnderecoDTO create(@PathVariable("idPessoa") Integer idPessoa,
                              @RequestBody @Valid EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        log.info("Criando endereço...");
        EnderecoDTO adress = enderecoService.create(idPessoa, enderecoCreateDTO);
        log.info("Endereço criado com sucesso");
        return adress;
    }

    @ApiOperation(value = "Atualiza um endereço pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o endereço atualizado com sucesso"),
            @ApiResponse(code = 400, message = "Erro, informação inserida inválida"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @PutMapping("/{idEndereco}")
    public EnderecoDTO update(@PathVariable("idEndereco") Integer idEndereco,
                              @RequestBody @Valid EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        return enderecoService.update(idEndereco, enderecoCreateDTO);
    }

    @ApiOperation(value = "Retorna uma lista de endereços")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de endereços"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping
    public List<EnderecoDTO> list(){
        return enderecoService.list();
    }

    @ApiOperation(value = "Busca endereço pelo id da pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna endereço com sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping("/{idPessoa}/pessoa")
    public List<EnderecoDTO> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) throws RegraDeNegocioException {
        return enderecoService.listByIdPessoa(idPessoa);
    }

    @ApiOperation(value = "Busca um endereço pelo id do endereço")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o endereço com sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping("/{idEndereco}")
    public EnderecoDTO findByIdEndereco(@PathVariable("idEndereco") Integer idEndereco) throws Exception {
        log.info("Alterando endereço...");
        EnderecoDTO adress = enderecoService.findById(idEndereco);
        log.info("Endereço alterado com sucesso");
        return adress;
    }

    @ApiOperation(value = "Delete um Endereço pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o endereço deletado com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer idEndereco) throws Exception {
        log.info("Deletando endereço...");
        enderecoService.delete(idEndereco);
        log.info("Endereço deletado com sucesso!");
    }
}