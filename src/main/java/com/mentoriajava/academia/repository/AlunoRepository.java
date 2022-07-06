package com.mentoriajava.academia.repository;

import com.mentoriajava.academia.model.entities.AlunoEntity;
import com.mentoriajava.academia.model.entities.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {
    Optional<AlunoEntity> findByCpf(String cpf);
}
