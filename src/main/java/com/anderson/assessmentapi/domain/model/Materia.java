package com.anderson.assessmentapi.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "materia")
public class Materia{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    @NotNull
    private String nome;

    @OneToMany(mappedBy = "materia", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonIgnore
    private List<Professor> professores;
}
