package com.dbc.pessoaapi.controller;

import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

//    public ContatoController() {
//        contatoService = new ContatoService();
//    }

    @PostMapping
    public Contato create(@RequestBody Contato contato) {
        return contatoService.create(contato);
    }

    @GetMapping
    public List<Contato> list() {
        return contatoService.list();
    }

    @GetMapping("/byidpessoa")
    public List<Contato> listByIdPessoa(@RequestParam("idPessoa") Integer id) {
        return contatoService.listByIdPessoa(id);
    }

    @GetMapping("/{idPessoa}")
    public List<Contato> listByIdPessoa1(@PathVariable("idPessoa") Integer id) {
        return contatoService.listByIdPessoa(id);
    }


    @PutMapping("/{idContato}")
    public Contato update(@PathVariable("idContato") Integer id,
                         @RequestBody Contato contatoAtualizar) throws Exception {
        return contatoService.update(id, contatoAtualizar);
    }

    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer id) throws Exception {
        contatoService.delete(id);
    }
}
