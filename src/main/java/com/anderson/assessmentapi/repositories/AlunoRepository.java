package com.anderson.assessmentapi.repositories;

import com.anderson.assessmentapi.domain.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    @Query(value = "select a from aluno a where a.nome = ?1")
    Aluno findByName(String nome);

    @Query(value = "select a from aluno a where a.ra = ?1")
    Aluno findAlunoByRegistro(String ra);

    @Query(value = "select a from aluno a where a.turma.nome = ?1")
    List<Aluno> findAllAlunosByTurma(String nome);

}
