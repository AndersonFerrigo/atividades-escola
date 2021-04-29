package com.anderson.assessmentapi.controllers;

import com.anderson.assessmentapi.domain.model.Professor;
import com.anderson.assessmentapi.handler.exceptions.ResourceNotFoundException;
import com.anderson.assessmentapi.repositories.MateriaRepository;
import com.anderson.assessmentapi.services.impl.ProfessorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorServiceImpl service;

    @Autowired
    private MateriaRepository materiaRepository;

    @PostMapping(value = "/{materia_id}")
    public Professor create(@PathVariable(value = "materia_id") int materia_id,
                                                        @RequestBody Professor professor) {

        return  materiaRepository.findById(materia_id).map( materia -> {
            professor.setMateria(materia);
            return service.createProfessor(professor);
        }).orElseThrow( () -> new ResourceNotFoundException(" Materia  não encontrada"));
    }

    @GetMapping
    public Optional<List<Professor>> professores(){
        return service.findAllProfessores();
    }

    @GetMapping(value = "id/{id}")
    public Optional<Professor> finProfessorById(@PathVariable(value = "id") int id ){
        return service.findProfessorById(id);
    }

    @GetMapping(value = "nome/{nome}")
    public Optional<Professor> finProfessorByNome(@PathVariable(value = "nome") String nome ){
        return service.findProfessorByNome(nome);
    }

    @GetMapping(value = "registro/{registro}")
    public Optional<Professor> finProfessorByRegistro(@PathVariable(value = "registro") String registro ){
        return service.findProfessorByRegistro(registro);
    }

    @GetMapping(value = "materia/{nome}")
    public Optional<List<Professor>> findProfessoresByMateria(@PathVariable(value = "nome") String nome){
        return service.findAllProfessoresByMateria(nome);
    }


    @PutMapping(value = "up/{id}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable(value = "id") int id,
                                        @RequestBody Professor professor){

        Professor professorUpdt = service.findProfessorById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Professor não encontrado para o id informado"));

        professorUpdt.setNome(professor.getNome());
        professorUpdt.setRegistroCFEP(professor.getRegistroCFEP());
        final Professor professorPut = service.createProfessor(professorUpdt);
        return ResponseEntity.ok(professorPut);
    }

    @DeleteMapping(value = "del/{id}")
    public Map<String,Boolean> deleteProfessor(@PathVariable(value = "id") int id){

        Professor professorDel = service.findProfessorById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Professor não encontrado para o id informado"));

        service.deleteProfessor(professorDel);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }

}
