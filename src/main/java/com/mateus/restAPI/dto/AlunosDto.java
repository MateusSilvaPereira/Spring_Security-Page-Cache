package com.mateus.restAPI.dto;

import com.mateus.restAPI.model.Alunos;
import com.mateus.restAPI.model.Cursos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunosDto {

    private Long id;
    private String usuario;

    private String cpf;
    private String email;
    private String nome;
    private String sobrenome;
    private String idade;
    private Cursos cursos;

    public AlunosDto(Alunos alunos) {
        this.id = alunos.getId();
        this.usuario = alunos.getUsuario();
        this.email = alunos.getEmail();
        this.nome = alunos.getNome();
        this.sobrenome = alunos.getSobrenome();
        this.idade = alunos.getIdade();
        this.cpf = alunos.getCpf();
        this.cursos= alunos.getCursos();
    }

    // Convert class AlunosDto Alunos
  public static Page<AlunosDto> convert(Page<Alunos> alunos){
    return alunos.map(AlunosDto :: new);
  }

}
