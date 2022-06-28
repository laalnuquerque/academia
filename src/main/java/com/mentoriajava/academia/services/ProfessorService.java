package com.mentoriajava.academia.services;

import com.mentoriajava.academia.model.dto.AlunoDto;
import com.mentoriajava.academia.model.dto.ProfessorDto;

public class ProfessorService {
    public void cadastrar(ProfessorDto professorDto){
        ProfessorDto professor = new ProfessorDto();
        professor.setId(professorDto.getId());
        professor.setNome(professorDto.getNome());
        professor.setCpf(professorDto.getCpf());
        professor.setEstadoCivil(professorDto.getEstadoCivil());
        professor.setCargo(professorDto.getCargo());
        professor.setSalario(professorDto.getSalario());
        professor.setDataInicioEmpresa(professorDto.getDataInicioEmpresa());

    }
}
