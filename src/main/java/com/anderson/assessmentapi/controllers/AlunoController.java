package com.anderson.assessmentapi.controllers;

import com.anderson.assessmentapi.domain.model.Aluno;
import com.anderson.assessmentapi.domain.model.Professor;
import com.anderson.assessmentapi.handler.exceptions.ResourceNotFoundException;
import com.anderson.assessmentapi.repositories.TurmaRepository;
import com.anderson.assessmentapi.services.impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;

    @Autowired
    private TurmaRepository turmaRepository;

    @PostMapping(value = "/{turma_id}")
    public Aluno createAluno(@PathVariable (value = "turma_id") int turma_id,
                                @RequestBody Aluno aluno){

        return turmaRepository.findById(turma_id).map( turma -> {
            aluno.setTurma(turma);
            return service.createAluno(aluno);
        }).orElseThrow( () -> new ResourceNotFoundException(" Materia  não encontrada"));
    }

    @GetMapping
    public Optional<List<Aluno>> alunos(){
        return service.findAll();
    }

    @GetMapping(value = "id/{id}")
    public Optional<Aluno> getAlunoById(@PathVariable("id") int id ){
        return service.findAlunoById(id);
    }

    @GetMapping(value = "ra/{ra}")
    public Optional<Aluno> getAlunoByRA(@PathVariable("ra") String ra ){
        return service.findAlunoByRegistro(ra);
    }

    @GetMapping(value = "nome/{nome}")
    public Optional<Aluno> getAlunoByNome(@PathVariable("nome") String nome ){
        return service.findAlunoByNome(nome);
    }

    @GetMapping(value = "turma/{turma}")
    public Optional<List<Aluno>> getAllAlunosByTurma(@PathVariable("turma") String turma ){
        return service.findAllAlunoByTurma(turma);
    }

    @PutMapping(value = "up/{id}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable(value = "id") int id,
                                                     @RequestBody Aluno aluno){

        Aluno alunoUpdt = service.findAlunoById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Aluno não encontrado para o id informado"));

        alunoUpdt.setNome(aluno.getNome());
        alunoUpdt.setRa(aluno.getRa());

        final Aluno alunoPut = service.createAluno(alunoUpdt);
        return ResponseEntity.ok(alunoPut);
    }

    @DeleteMapping(value = "del/{id}")
    public Map<String,Boolean> deleteAluno(@PathVariable(value = "id") int id){

        Aluno alunoDel = service.findAlunoById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Aluno não encontrado para o id informado"));

        service.deleteAluno(alunoDel);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }

}
