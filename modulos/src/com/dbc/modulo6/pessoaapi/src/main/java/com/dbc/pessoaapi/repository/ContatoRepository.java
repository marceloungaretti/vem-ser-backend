package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.ContatoEntity;
import com.dbc.pessoaapi.entity.TipoContato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ContatoRepository extends JpaRepository<ContatoEntity, Integer> {

    //corrigirrr
//    @Query(value = "SELECT * FROM CONTATO c WHERE c.id_pessoa = :idPessoa", nativeQuery = true)
//    List<ContatoEntity> findContatoPorIdPessoa(Integer idPessoa);

    @Query("select p from CONTATO p where p.tipo = :tipo ")
    List<ContatoEntity> listaPorTipoContato(TipoContato tipo);
}
