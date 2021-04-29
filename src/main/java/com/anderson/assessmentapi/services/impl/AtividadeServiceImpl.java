package com.anderson.assessmentapi.services.impl;

import com.anderson.assessmentapi.domain.dto.AtividadeDto;
import com.anderson.assessmentapi.domain.model.Aluno;
import com.anderson.assessmentapi.domain.model.Atividade;
import com.anderson.assessmentapi.repositories.AtividadeRepository;
import com.anderson.assessmentapi.services.AtividadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtividadeServiceImpl implements AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    public Optional<List<Atividade>> findAllAtividades(){
        return Optional.of(atividadeRepository.findAll());
    }


    @Override
    public List<Atividade> findAllAtividadesPerson() {
        return atividadeRepository.findAllAtividade();
    }
}
