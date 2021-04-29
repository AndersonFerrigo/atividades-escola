package com.anderson.assessmentapi.domain.dto;

import com.anderson.assessmentapi.domain.model.Atividade;
import com.anderson.assessmentapi.domain.model.Materia;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDto implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    @NotNull
    private String nome;

    @Column(name = "registro_cfep")
    @NotNull
    private String registroCFEP;

    @Column(name = "materia_id")
    private int materia_id;
}

