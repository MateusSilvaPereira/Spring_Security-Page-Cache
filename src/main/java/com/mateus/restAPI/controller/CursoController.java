package com.mateus.restAPI.controller;

import com.mateus.restAPI.model.Cursos;
import com.mateus.restAPI.repository.CursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursosRepository cursosRepository;

    @GetMapping("/")
    public ResponseEntity<List<Cursos>> cursosList(){
        List<Cursos> listCurso = cursosRepository.findAll();
        return ResponseEntity.ok(listCurso);
    }
}
