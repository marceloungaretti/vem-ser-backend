
package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.EnderecoCreateDTO;
import com.dbc.pessoaapi.dto.EnderecoDTO;
import com.dbc.pessoaapi.dto.PessoaComEnderecoDTO;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.exceptions.RegraDeNegocioException;
import com.dbc.pessoaapi.repository.EnderecoRepository;
import com.dbc.pessoaapi.service.EnderecoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Validated
@RestController
@RequestMapping("/endereco")
@RequiredArgsConstructor
@Slf4j
public class EnderecoController {
    private final EnderecoService enderecoService;
    private final EnderecoRepository enderecoRepository;

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

//    @ApiOperation(value = "Busca endereço pelo id da pessoa")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Retorna endereço com sucesso"),
//            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
//    })
//    @GetMapping("/{idPessoa}/pessoa")
//    public List<EnderecoDTO> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) throws RegraDeNegocioException {
//        return enderecoService.getByIdPessoa(idPessoa);
//    }

    @ApiOperation(value = "Busca um endereço pelo id do endereço")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o endereço com sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping("/{idEndereco}")
    public EnderecoDTO getById(@RequestParam("idEndereco") Integer idEndereco) throws RegraDeNegocioException {
            return enderecoService.getById(idEndereco);
    }


    @ApiOperation(value = "Delete um Endereço pelo seu id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o endereço deletado com sucesso"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer idEndereco) throws RegraDeNegocioException {
        log.info("Deletando endereço...");
        enderecoService.delete(idEndereco);
        log.info("Endereço deletado com sucesso!");
    }


    @ApiOperation(value = "Busca os endereços de um pais")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna os endereços com sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping("/endereco-por-pais")
    public List<EnderecoEntity> listEnderecosPorPais(@RequestParam String pais) {
        return enderecoRepository.listEnderecosPorPais(pais);
    }

    //corrigir
    @ApiOperation(value = "Endereços por ID da Pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna os endereços com sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping("/enderecos-por-idpessoa")
    public List<EnderecoEntity> listaEnderecosPorIdPessoa(@RequestParam Integer idPessoa) {
        return enderecoRepository.listEnderecosPorIdPessoa(idPessoa);
    }

    @ApiOperation(value = "(native) Endereços por Cidade OU Pais")
    @GetMapping("/endereco-por-cidade-pais-native")
    public List<EnderecoEntity> findEnderecoCidadePais(@RequestParam String cidade, @RequestParam String pais) {
        return enderecoRepository.findEnderecoCidadePais(cidade, pais);
    }

    @ApiOperation(value = "(native)Endereços complemento null")
    @GetMapping("/endereco-complemento-null-native")
    public List<EnderecoEntity> findEnderecoComplementoIsNull() {
        return enderecoRepository.findEnderecoComplementoIsNull();
    }
}