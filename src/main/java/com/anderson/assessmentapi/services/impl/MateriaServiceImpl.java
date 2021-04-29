package com.anderson.assessmentapi.services.impl;

import com.anderson.assessmentapi.domain.model.Materia;
import com.anderson.assessmentapi.repositories.MateriaRepository;
import com.anderson.assessmentapi.services.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class MateriaServiceImpl implements MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    public Materia createMateria(Materia materia){
        return materiaRepository.save(materia);
    }

    public List<Materia> findAllMaterias(){
        return materiaRepository.findAllMateria();
    }

    public Optional<Materia> findById(int id){
        return materiaRepository.findById(id);
    }

    public Optional<Materia> findByName(String nome){
        return materiaRepository.findByName(nome);
    }

}
