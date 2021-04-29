package com.anderson.assessmentapi.controllers;

import com.anderson.assessmentapi.domain.model.Materia;
import com.anderson.assessmentapi.domain.model.Turma;
import com.anderson.assessmentapi.handler.exceptions.ResourceNotFoundException;
import com.anderson.assessmentapi.repositories.TurmaRepository;
import com.anderson.assessmentapi.services.impl.TurmaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    private TurmaServiceImpl service;

    @PostMapping
    public Turma create(@RequestBody Turma turma){
        return service.create(turma);
    }

    @GetMapping
    public Optional<List<Turma>> turmas(){
        return service.findAllTurmas();
    }

    @GetMapping(value = "/id/{id}")
    public Optional<Turma> findById(@PathVariable (value = "id") int id){
        return service.findById(id);
    }

    @GetMapping(value = "/nome/{nome}")
    public Optional<Turma> findByNome(@PathVariable (value = "nome") String nome){
        return Optional.of(service.findByNome(nome));
    }

    @PutMapping(value = "up/{id}")
    public ResponseEntity<Turma> updateTurma(@PathVariable(value = "id") int id,
                                             @RequestBody Turma turma){
        Turma turmaUpdt = service.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Turma não encontrada para o id informado"));

        turmaUpdt.setNome(turma.getNome());
        final Turma turmaPut = service.create(turmaUpdt);
        return  ResponseEntity.ok(turmaPut);
    }

    @DeleteMapping(value = "del/{id}")
    public Map<String, Boolean> deleteMateria(@PathVariable (value = "id") int id ){
        Turma turmaDel = service.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Turma não encontrada para o id informado"));

        service.delete(turmaDel);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }

}
