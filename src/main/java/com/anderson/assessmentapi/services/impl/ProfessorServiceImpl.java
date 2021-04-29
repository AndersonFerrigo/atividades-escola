package com.anderson.assessmentapi.services.impl;

import com.anderson.assessmentapi.domain.model.Professor;
import com.anderson.assessmentapi.repositories.ProfessorRepository;
import com.anderson.assessmentapi.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService{

    @Autowired
    private ProfessorRepository professorRepository;

    public Professor createProfessor (Professor professor){
        return professorRepository.save(professor);
    }

    public Optional<List<Professor>> findAllProfessores(){
        return Optional.of(professorRepository.findAll());
    }

    public Optional<Professor> findProfessorById(int id){
        return professorRepository.findById(id);
    }

    public Optional<Professor> findProfessorByNome(String nome){
        return Optional.of(professorRepository.findByName(nome));
    }

    public Optional<Professor> findProfessorByRegistro(String registro){
        return Optional.of(professorRepository.findByRegistro(registro));
    }

    public Optional<List<Professor>> findAllProfessoresByMateria(String nome){
        return Optional.of(professorRepository.findAllProfessoresByMateria(nome));
    }


    public void deleteProfessor(Professor professor){
        professorRepository.delete(professor);
    }

}
