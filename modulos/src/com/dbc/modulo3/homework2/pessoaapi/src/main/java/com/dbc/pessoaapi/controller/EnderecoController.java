package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        enderecoService.delete(id);
    }

    @PostMapping("/{idPessoa}")
    public EnderecoEntity create(@PathVariable("idPessoa") Integer idPessoa,
                                 @RequestBody EnderecoEntity enderecoEntity){
        return enderecoService.create(idPessoa, enderecoEntity);
    }

    @PutMapping("/{id}")
    public EnderecoEntity update(@PathVariable("id") Integer id,
                                 @RequestBody EnderecoEntity enderecoEntity) throws Exception {
        return enderecoService.update(id, enderecoEntity);
    }

    @GetMapping
    public List<EnderecoEntity> list() {
        return enderecoService.list();
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<EnderecoEntity> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return enderecoService.listByIdPessoa(idPessoa);
    }

    @GetMapping("/{idEndereco}")
    public EnderecoEntity findById(@PathVariable("idEndereco") Integer id) throws Exception {
        return enderecoService.findById(id);
    }
}
