package com.anderson.assessmentapi.controllers;

import com.anderson.assessmentapi.domain.dto.AtividadeDto;
import com.anderson.assessmentapi.domain.model.Atividade;
import com.anderson.assessmentapi.services.impl.AtividadeServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/atividade")
public class AtividadeController {

    @Autowired
    private AtividadeServiceImpl service;

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping
    public Optional<List<Atividade>> atividades(){
        return service.findAllAtividades();
    }

    @GetMapping(value = "person")
    public Optional<List<AtividadeDto>> getAllAtividades(){
        return Optional.ofNullable(
                service.findAllAtividadesPerson()
                        .stream()
                        .map(this::toAtividadeSumary)
                        .collect(Collectors.toList()));
    }

    private AtividadeDto toAtividadeSumary(Atividade atividade){
        return modelMapper.map(atividade, AtividadeDto.class);
    }
}
