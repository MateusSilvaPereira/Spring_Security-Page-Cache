package com.mateus.restAPI.dto;

import com.mateus.restAPI.model.Cursos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDto {

    private Long id;
    private String curso;
    private LocalDate dataInicio;
    private LocalDate dataConclusao;
    private Long nota;

    public CursoDto(Cursos cursos) {
        this.id = cursos.getId();
        this.curso = cursos.getCurso();
        this.dataInicio = cursos.getDataInicio();
        this.dataConclusao = cursos.getDataConclusao();
        this.nota = cursos.getNota();
    }
}
