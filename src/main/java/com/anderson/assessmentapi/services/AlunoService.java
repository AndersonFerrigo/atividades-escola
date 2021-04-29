package com.anderson.assessmentapi.services;

import com.anderson.assessmentapi.domain.model.Aluno;
import com.anderson.assessmentapi.domain.model.Professor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public interface AlunoService {

    Aluno createAluno (Aluno aluno);

    Optional<List<Aluno>> findAll();
    Optional<Aluno> findAlunoById(int id);
    Optional<Aluno> findAlunoByNome(String nome);
    Optional<Aluno> findAlunoByRegistro(String ra);
    Optional<List<Aluno>> findAllAlunoByTurma(String turma);

    ResponseEntity<Aluno> updateAluno(Aluno aluno);
    Map<String,Boolean> deleteAluno(Aluno aluno);
}
