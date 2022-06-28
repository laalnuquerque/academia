package com.mentoriajava.academia.services;

import com.mentoriajava.academia.model.dto.AlunoDto;
import com.mentoriajava.academia.model.dto.ProfessorDto;

public class ProfessorService {
    public void cadastroProfessor(ProfessorDto professorDto){
        AlunoDto professor = new AlunoDto();
        professor.setId(professorDto.getId());
        professor.setNome(professorDto.getNome());
        professor.setCpf(professorDto.getCpf());

    }
}
