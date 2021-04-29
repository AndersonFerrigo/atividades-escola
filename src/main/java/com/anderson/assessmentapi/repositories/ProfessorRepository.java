package com.anderson.assessmentapi.repositories;

import com.anderson.assessmentapi.domain.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    @Query(value = "select p from professor p where p.nome = ?1")
    Professor findByName(String nome);

    @Query(value = "select p from professor p where p.registroCFEP = ?1")
    Professor findByRegistro(String registro);

    @Query(value = "select p from professor p where p.materia.nome = ?1")
    List<Professor> findAllProfessoresByMateria(String nome);


}
