package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

    List<PessoaEntity> findByNomeContainsIgnoreCase(String nome);
    PessoaEntity findByCpf(String cpf);
    List<PessoaEntity> findByDataNascimentoBetween(LocalDate inicial, LocalDate finale);
}
