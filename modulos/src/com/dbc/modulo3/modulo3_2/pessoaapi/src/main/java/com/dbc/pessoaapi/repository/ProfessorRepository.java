package com.dbc.pessoaapi.repository;

import com.dbc.pessoaapi.entity.ProfessorEntity;
import com.dbc.pessoaapi.entity.ProfessorPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, ProfessorPK> {
}
