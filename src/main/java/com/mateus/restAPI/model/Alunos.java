package com.mateus.restAPI.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Entity
@Data
public class Alunos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String senha;

    @NotNull
    @NotEmpty
    @Length(min = 3, max = 50, message = "O comprimento deve ser entre 8 e 50 caracteres.")
    private String usuario;

    @CPF(message = "(CPF) inválido, por favor informe um CPF válido.")
    @NotNull @NotEmpty @Column(name = "cpf")
    private String cpf;

    @NotNull
    @NotEmpty
    @Email(message = "Informe um endereço de e-mail válido.")
    private String email;

    @NotNull
    @NotEmpty
    @Length(min = 5, max = 50, message = "O comprimento deve ser entre 5 e 50 caracteres.")
    private String nome;

    @NotNull
    @NotEmpty
    @Length(min = 5, max = 60, message = "O comprimento deve ser entre 5 e 60 caracteres.")
    private String sobrenome;

    @NotNull
    @NotEmpty
    @Length(min = 2, max = 3)
    private String idade;

    @ManyToOne
    private Cursos cursos;

}
