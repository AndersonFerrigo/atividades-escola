package com.anderson.assessmentapi.repositories;

import com.anderson.assessmentapi.domain.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {

    @Query(value = "select t from turma t where t.nome = ?1")
    Turma findByName(String nome);
}
