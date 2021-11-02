package com.dbc.pessoaapi.controller;


import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {
    @Autowired
    private ContatoService contatoService;

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        contatoService.delete(id);
    }

    @PostMapping("/{idPessoa}")
    public ContatoEntity create(@PathVariable("idPessoa") Integer idPessoa,
                                @RequestBody ContatoEntity contatoEntity) throws Exception {
        return contatoService.create(idPessoa, contatoEntity);
    }

    @PutMapping("/{id}")
    public ContatoEntity update(@PathVariable("id") Integer id,
                                @RequestBody ContatoEntity contatoEntity) throws Exception {
        return contatoService.update(id, contatoEntity);
    }

    @GetMapping
    public List<ContatoEntity> list() {
        return contatoService.list();
    }

    // {{url}}/contato/1/pessoa
    @GetMapping("/{idPessoa}/pessoa")
    public List<ContatoEntity> listByIdPessoa(@PathVariable("idPessoa") Integer idPessoa) {
        return contatoService.listByIdPessoa(idPessoa);
    }

    // {{url}}/contato/1/contato
    @GetMapping("/{idContato}/contato")
    public ContatoEntity listByIdContato(@PathVariable("idContato") Integer idContato) throws Exception {
        return contatoService.listByIdContato(idContato);
    }

    // {{url}}/contato/list-by-pessoas?idPessoa=1&nome=Maicon Machado
    @GetMapping("/list-by-pessoas")
    public List<ContatoEntity> listByIdPessoaRequestParam(@RequestParam("idPessoa") Integer id,
                                                          @RequestParam("nome") String nome) {
        System.out.println(nome);
        return contatoService.listByIdPessoa(id);
    }
}