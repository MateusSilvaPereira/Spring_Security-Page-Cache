package com.mateus.restAPI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Temporal;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cursos {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull @NotEmpty
    private String curso;

    @NotNull @NotEmpty
    private LocalDate dataInicio;

    @NotNull @NotEmpty
    private LocalDate dataConclusao;

    @NotNull @NotEmpty
    private Long nota;

}
