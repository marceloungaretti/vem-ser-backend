package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {
//    @Query(value = "SELECT E FROM ENDERECO_PESSOA E WHERE E.ID_PESSOA = :idPessoa", nativeQuery = true)
//    List<EnderecoEntity> listEnderecosPorIdPessoa(@Param("idPessoa") Integer idPessoa);

    @Query(value = "SELECT E FROM ENDERECO_PESSOA E WHERE PAIS = :pais")
    List<EnderecoEntity> listEnderecosPorPais(String pais);

    //corrigir
//    @Query(value = "SELECT E FROM ENDERECO_PESSOA E WHERE E.idPessoa = :idPessoa")
//    List<EnderecoEntity> listEnderecosPorIdPessoa(Integer idPessoa);

//    @Query("select p from PESSOA p where where p.cpf = ?1")
//    PessoaEntity procurarPorCpf(String cpf);
//
//    @Query("select p from PESSOA p where where p.cpf = :meuCpf")
//    PessoaEntity procurarPorCpfParam(@Param("meuCpf") String cpf);
}