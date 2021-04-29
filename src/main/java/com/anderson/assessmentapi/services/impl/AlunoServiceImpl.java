package com.anderson.assessmentapi.services.impl;

import com.anderson.assessmentapi.domain.model.Aluno;
import com.anderson.assessmentapi.repositories.AlunoRepository;
import com.anderson.assessmentapi.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.support.incrementer.HanaSequenceMaxValueIncrementer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AlunoServiceImpl implements AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public Aluno createAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public Optional<List<Aluno>> findAll() {
        return Optional.of(alunoRepository.findAll());
    }

    @Override
    public Optional<Aluno> findAlunoById(int id) {
        return alunoRepository.findById(id);
    }

    @Override
    public Optional<Aluno> findAlunoByNome(String nome) {
        return Optional.of(alunoRepository.findByName(nome));
    }

    @Override
    public Optional<Aluno> findAlunoByRegistro(String ra) {
        return Optional.of(alunoRepository.findAlunoByRegistro(ra));
    }

    @Override
    public Optional<List<Aluno>> findAllAlunoByTurma(String turma) {
        return Optional.of(alunoRepository.findAllAlunosByTurma(turma));
    }

    @Override
    public ResponseEntity<Aluno> updateAluno(Aluno aluno) {
        return ResponseEntity.ok(aluno);
    }

    @Override
    public Map<String, Boolean> deleteAluno(Aluno aluno) {
        alunoRepository.delete(aluno);
        Map<String, Boolean> response = new HashMap<String, Boolean>();
        return response;
    }
}
