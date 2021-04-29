package com.anderson.assessmentapi.repositories;

import com.anderson.assessmentapi.domain.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Integer> {

    @Query(value = "select m from materia m")
    List<Materia> findAllMateria();

    @Query(value = "select m from materia m where m.nome = ?1")
    Optional<Materia> findByName(String nome);

}
