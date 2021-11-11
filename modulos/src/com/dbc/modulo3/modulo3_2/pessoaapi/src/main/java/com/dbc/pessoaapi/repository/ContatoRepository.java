package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.ContatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer> {

    @Query(value = "SELECT * FROM CONTATO C WHERE C.ID_PESSOA = idPessoa", nativeQuery = true)
    List<ContatoEntity> listContatosPorIdPessoa(Integer idPessoa);
}
