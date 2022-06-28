package com.mentoriajava.academia.services;

import com.mentoriajava.academia.model.dto.AlunoDto;

public class AlunoService {
    public void cadastrar(AlunoDto alunoDto){
        AlunoDto aluno = new AlunoDto();
        aluno.setId(alunoDto.getId());
        aluno.setNome(alunoDto.getNome());
        aluno.setCpf(alunoDto.getCpf());
        aluno.setEstadoCivil(alunoDto.getEstadoCivil());
        aluno.setDataMatricula(alunoDto.getDataMatricula());
        aluno.setNivel(alunoDto.getNivel());
    }
}
