package com.mateus.restAPI.repository;

import com.mateus.restAPI.model.Cursos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursosRepository extends JpaRepository<Cursos, Long> {

}
