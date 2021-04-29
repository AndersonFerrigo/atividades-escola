package com.anderson.assessmentapi.repositories;

import com.anderson.assessmentapi.domain.dto.AtividadeDto;
import com.anderson.assessmentapi.domain.model.Atividade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long> {

    @Query(value = "select a.id, a.dataPost, a.dataEntrega, a.conteudo, t.nome, p.nome,p.materia.nome"+
                    " from atividade a" +
                    " left join turma t on a.turma.id = t.id" +
                    " left join professor p on a.professor.id = p.id" +
                    " order by a.id ASC")
    List<Atividade> findAllAtividade();

}
