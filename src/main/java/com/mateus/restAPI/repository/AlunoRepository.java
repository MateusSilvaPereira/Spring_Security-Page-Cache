package com.mateus.restAPI.repository;

import com.mateus.restAPI.model.Alunos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Alunos, Long> {
}
