package com.anderson.assessmentapi.domain.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class AtividadeDto implements Serializable {
    private int id;
    private String dataPost;
    private String dataEntrega;
    public String conteudo;
    private String turmanome;
    private String professornome;
    private String professormaterianome;

}
