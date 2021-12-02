package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.EnderecoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {
    @Query("select p from ENDERECO_PESSOA p join p.pessoas pe where pe.idPessoa = :idPessoa")
    List<EnderecoEntity> listEnderecosPorIdPessoa(@Param("idPessoa") Integer idPessoa);

    @Query(value = "SELECT E FROM ENDERECO_PESSOA E WHERE upper(pais) like upper(:pais)")
    List<EnderecoEntity> listEnderecosPorPais(String pais);

    @Query(value = "SELECT * FROM ENDERECO_PESSOA e WHERE upper(cidade) like upper(:cidade) OR upper(pais) like upper(:pais)", nativeQuery = true)
    List<EnderecoEntity> findEnderecoCidadePais(String cidade, String pais);

    @Query(value = "SELECT * FROM ENDERECO_PESSOA e WHERE complemento is null", nativeQuery = true)
    List<EnderecoEntity> findEnderecoComplementoIsNull();

    @Query(value = "SELECT E FROM ENDERECO_PESSOA E WHERE upper(pais) like upper(:pais)")
    Page<EnderecoEntity> paginarEnderecosPorPais(String pais, Pageable pageable);



//    @Query("select p from PESSOA p where where p.cpf = ?1")
//    PessoaEntity procurarPorCpf(String cpf);
//
//    @Query("select p from PESSOA p where where p.cpf = :meuCpf")
//    PessoaEntity procurarPorCpfParam(@Param("meuCpf") String cpf);
}