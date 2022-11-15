package com.mateus.restAPI.controller;

import com.mateus.restAPI.dto.AlunosDto;
import com.mateus.restAPI.model.Alunos;
import com.mateus.restAPI.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

//    @GetMapping("/{id}")
//    public Alunos buscarPorId(@PathVariable Long id) {
//        return alunoRepository.findById(id)
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não Encontrado."));
//    }

    @GetMapping("/")
    @Cacheable(value ="listaAlunos",sync = false)
    @CacheEvict(value = "listaAlunos", allEntries = true)
    public Page<AlunosDto> listaAlunos(@RequestParam(required = false) String aluno,
                                       @PageableDefault(sort = "id", direction = Sort.Direction.DESC)
                                       Pageable paginacao
                                       ) {
        Page<Alunos> alunosPage= alunoRepository.findAll(paginacao);
        return AlunosDto.convert(alunosPage);
    }

    @GetMapping("/{idAluno}")
    public ResponseEntity<AlunosDto> consultarPorId(@PathVariable Long idAluno) {

        Optional<Alunos> alunos = alunoRepository.findById(idAluno);
        if (alunos.isPresent()) {
            return ResponseEntity.ok(new AlunosDto(alunos.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    @CacheEvict(value = "listaAlunos", allEntries = true)
    public ResponseEntity<Alunos> add(@Valid @RequestBody Alunos alunos) {
        Alunos objAluno = alunoRepository.save(alunos);
        return new ResponseEntity<Alunos>(objAluno, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @CacheEvict(value = "listaAlunos", allEntries = true)
    public ResponseEntity<Alunos> iditar(@PathVariable Long id, @RequestBody Alunos alunos) {

        if (!alunoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        } else {
            alunos.setId(id);
            alunos = alunoRepository.save(alunos);

            return ResponseEntity.ok(alunos);
        }
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value = "listaAlunos", allEntries = true)
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        if (!alunoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        } else {
            alunoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
    }

}
