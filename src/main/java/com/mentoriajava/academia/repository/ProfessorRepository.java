package com.mentoriajava.academia.repository;

import com.mentoriajava.academia.model.entities.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Entity e tipo da chave primaria

//mostra pro spring que e repositorio
@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Long> {
}