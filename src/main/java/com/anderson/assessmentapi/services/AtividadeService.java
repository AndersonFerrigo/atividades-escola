package com.anderson.assessmentapi.services;

import com.anderson.assessmentapi.domain.dto.AtividadeDto;
import com.anderson.assessmentapi.domain.model.Aluno;
import com.anderson.assessmentapi.domain.model.Atividade;

import java.util.List;

public interface AtividadeService {
    List<Atividade> findAllAtividadesPerson();
}
