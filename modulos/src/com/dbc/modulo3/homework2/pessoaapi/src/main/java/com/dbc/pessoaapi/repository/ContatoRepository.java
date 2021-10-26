package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.Contato;
import com.dbc.pessoaapi.entity.Pessoa;
import com.dbc.pessoaapi.entity.TipoContato;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ContatoRepository {
    private static List<Contato> listaContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();
    private AtomicInteger COUNTER2 = new AtomicInteger();

    public ContatoRepository() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //18/10/2020
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), COUNTER2.incrementAndGet(), TipoContato.COMERCIAL, "111111110", "Contato antigo"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), COUNTER2.incrementAndGet(), TipoContato.RESIDENCIAL, "12222222", "Contato novo"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), COUNTER2.incrementAndGet(), TipoContato.COMERCIAL, "3333333333", "Contato alternativo"));
    }

    public Contato create(Contato contato) {
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }


    public List<Contato> list() {
        return listaContatos;
    }

    public List<Contato> listByIdPessoa(Integer id) {
        return listaContatos.stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .collect(Collectors.toList());
    }

    public Contato update(Integer id, Contato contatoAtualizar) throws Exception {
        Contato contatoRecuperado = listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não encontrado"));
        contatoRecuperado.setIdPessoa(contatoAtualizar.getIdPessoa());
        contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());
        return contatoRecuperado;
    }

    public void delete(Integer id) throws Exception {
        Contato contatoRecuperado = listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não encontrado"));
        listaContatos.remove(contatoRecuperado);
    }
}
