package com.mentoriajava.academia.services;

import com.mentoriajava.academia.model.dto.AlunoDto;
import com.mentoriajava.academia.model.dto.ProfessorDto;
import com.mentoriajava.academia.model.entities.AlunoEntity;
import com.mentoriajava.academia.model.entities.ProfessorEntity;
import com.mentoriajava.academia.repository.AlunoRepository;
import com.mentoriajava.academia.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.mentoriajava.academia.model.enums.Respostas.*;

@Component
public class AlunoService {

    private AlunoRepository alunoRepository;

    @Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;

    }
    public String cadastrar(AlunoDto alunoDto){
        AlunoEntity aluno = converterEntity(alunoDto);
        Optional<AlunoEntity> alunoResultado = alunoRepository.findByCpf(aluno.getCpf());
        if (alunoResultado.isEmpty()){
            alunoRepository.save(aluno);
            return RESPOSTAOK;
        } else {
            return RESPOSTANOK;
        }
    }

    public void consultar(){

    }

    public void atualizar(){

    }

    public void delete(){

    }

    private AlunoDto converterDto(AlunoEntity alunoEntity) {
        AlunoDto aluno = new AlunoDto();
        aluno.setId(alunoEntity.getId());
        aluno.setNome(alunoEntity.getNome());
        aluno.setCpf(alunoEntity.getCpf());
        aluno.setNivel(alunoEntity.getNivel());
        aluno.setDataMatricula(alunoEntity.getDataMatricula());
        return aluno;
    }

    private AlunoEntity converterEntity(AlunoDto alunoDto) {
        AlunoEntity aluno = new AlunoEntity();
        aluno.setId(alunoDto.getId());
        aluno.setNome(alunoDto.getNome());
        aluno.setCpf(alunoDto.getCpf());
        aluno.setEstadoCivil(alunoDto.getEstadoCivil());
        aluno.setNivel(alunoDto.getNivel());
        aluno.setDataMatricula(alunoDto.getDataMatricula());

        return aluno;
    }
}
