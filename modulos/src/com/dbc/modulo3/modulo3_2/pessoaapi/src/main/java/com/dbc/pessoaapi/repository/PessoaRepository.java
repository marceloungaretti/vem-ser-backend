package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.EnderecoEntity;
import com.dbc.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

    @Query("select p from PESSOA p where p.dataNascimento BETWEEN :inicial AND :finale" )
    List<PessoaEntity> findPessoasComNascimentoBetween(LocalDate inicial, LocalDate finale);

    @Query("select p from PESSOA p join p.enderecos e")
    List<PessoaEntity> findByExistingEndereco();

    ///corrigir
//    @Query("select p from ENDERECO_PESSOA p join p.pessoas pe where p.endereco is null")
//    List<PessoaEntity> findBySemEndereco();






//    @Query("select p from PESSOA p where where p.cpf = ?1")
//    PessoaEntity procurarPorCpf(String cpf);
//
//    @Query("select p from PESSOA p where where p.cpf = :meuCpf")
//    PessoaEntity procurarPorCpfParam(@Param("meuCpf") String cpf);
//
//    @Query("select p from PESSOA p where where p.cpf = :meuCpf")
//    PessoaEntity procurarPorCpfNomeIgual(@Param("meuCpf") String meuCpf);
//
//    @Query("select p from PESSOA p where where p.cpf = :meuCpf and p.nome = :nome")
//    PessoaEntity procurarPorCpfParam(@Param("meuCpf") String cpf, String nome);
//
//    @Query("select p from PESSOA p left join p.contatos c")
//    List<PessoaEntity> procurarPessoasEContatos();

}
