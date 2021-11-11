package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {
    @Query(value = "SELECT * FROM ENDERECO_PESSOA E WHERE E.ID_PESSOA = idPessoa", nativeQuery = true)
    List<EnderecoEntity> listEnderecosPorIdPessoa(Integer idPessoa);
}