package com.anderson.assessmentapi.services.impl;

import com.anderson.assessmentapi.domain.model.Turma;
import com.anderson.assessmentapi.repositories.TurmaRepository;
import com.anderson.assessmentapi.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaServiceImpl implements TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public Turma create(Turma turma){
        return turmaRepository.save(turma);
    }

    public Optional<List<Turma>> findAllTurmas(){
        return Optional.of(turmaRepository.findAll());
    }

    public Optional<Turma> findById(int id){
        return turmaRepository.findById(id);
    }

    public Turma findByNome(String nome){
        return turmaRepository.findByName(nome);
    }

    public void delete(Turma turma){
        turmaRepository.delete(turma);
    }
}
