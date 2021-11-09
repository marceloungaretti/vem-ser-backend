package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.dto.PessoaCreateDTO;
import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.ProfessorEntity;
import com.dbc.pessoaapi.repository.ProfessorRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/professor")
@Validated
@RequiredArgsConstructor
@Slf4j
public class ProfessorController {
    private final ProfessorRepository professorRepository;

    @ApiOperation(value = "Cria um novo professor")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna o professor criado com sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @PostMapping
    public ProfessorEntity create(@RequestBody @Valid ProfessorEntity professorEntity)throws Exception{
        return professorRepository.save(professorEntity);
    }

    @ApiOperation(value = "Retorna uma lista de professores")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de professores"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção")
    })
    @GetMapping
    public List<ProfessorEntity> list() {
        return new ArrayList<>(professorRepository.findAll());
    }


}
