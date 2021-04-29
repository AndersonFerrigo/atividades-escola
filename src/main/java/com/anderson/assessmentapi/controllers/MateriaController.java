package com.anderson.assessmentapi.controllers;

import com.anderson.assessmentapi.domain.model.Materia;
import com.anderson.assessmentapi.handler.exceptions.ResourceNotFoundException;
import com.anderson.assessmentapi.repositories.MateriaRepository;
import com.anderson.assessmentapi.services.impl.MateriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/materia")
public class MateriaController {

    @Autowired
    private MateriaServiceImpl service;

    @Autowired
    private MateriaRepository repository;

    @PostMapping
    public Materia create(@RequestBody Materia materia){
        return service.createMateria(materia);
    }

    @GetMapping
    public Optional<List<Materia>> materias(){
        return Optional.of(service.findAllMaterias());
    }

    @GetMapping(value = "id/{id}")
    public Optional<Materia> findMateriaById(@PathVariable int id){
        return service.findById(id);
    }

    @GetMapping(value = "nome/{nome}")
    public Optional<Materia> findMateriaByName(@PathVariable String nome){
        return service.findByName(nome);
    }

    @PutMapping(value = "up/{id}")
    public ResponseEntity<Materia> updateMAteria(@PathVariable(value = "id") int id,
                                                        @RequestBody Materia materia){
        Materia materiaUpdt = service.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Materia não encontrada para o id informado"));

        materiaUpdt.setNome(materia.getNome());
        final Materia materiaUpdated = service.createMateria(materiaUpdt);
        return ResponseEntity.ok(materiaUpdated);
    }

    @DeleteMapping(value = "del/{id}")
    public Map<String, Boolean> deleteMateria(@PathVariable (value = "id") int id ){
        Materia materiaDel = service.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Materia não encontrada para o id informado"));

        repository.delete(materiaDel);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }
}
