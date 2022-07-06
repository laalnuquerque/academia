package com.mentoriajava.academia.services;

import com.mentoriajava.academia.model.dto.ProfessorDto;
import com.mentoriajava.academia.model.entities.ProfessorEntity;
import com.mentoriajava.academia.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.mentoriajava.academia.model.enums.Respostas.RESPOSTAOK;
import static com.mentoriajava.academia.model.enums.Respostas.RESPOSTANOK;


@Component
public class ProfessorService {

    private ProfessorRepository professorRepository;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;

    }

    public ResponseEntity cadastrar(ProfessorDto professorDto){
        ProfessorEntity professor = converterEntity(professorDto);
        Optional<ProfessorEntity> professorBuscar = professorRepository.findByCpf(professorDto.getCpf());
        if (professorBuscar.isEmpty()) {
            professorRepository.save(professor);
            return ResponseEntity.status(HttpStatus.OK).body("Professor cadastrado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Professor existente no sistema");
        }
    }


    public ProfessorDto consultar(String cpf){
        //verificar o que o findbyId esta retornando e criar ele para retornar o que busquei
        Optional<ProfessorEntity> professorResultado = professorRepository.findByCpf(cpf);
        //Optional<ProfessorEntity> professorResultado = professorRepository.findByNome("Johannes Merschbacher");
        if (professorResultado.isEmpty()) {
            return null;
        } else {
            ProfessorDto professorConvertido = converterDto(professorResultado.get());
            return professorConvertido;
        }
    }

    public String atualizar(ProfessorDto  professorDto){
        ProfessorEntity professorAtualizar = converterEntity(professorDto);
        Optional<ProfessorEntity> professorResultadoAtualizar = professorRepository.findByCpf(professorAtualizar.getCpf());
        if (professorResultadoAtualizar.isEmpty()) {
            return RESPOSTANOK;
        }
        professorAtualizar.setId(professorResultadoAtualizar.get().getId());
        professorAtualizar.setDataInicioEmpresa(professorResultadoAtualizar.get().getDataInicioEmpresa());
        professorRepository.save(professorAtualizar);
        return RESPOSTAOK;
    }

    public String deletar(String cpf){
        Optional<ProfessorEntity> professorDeletar = professorRepository.findByCpf(cpf);
        if (professorDeletar.isEmpty()) {
            return RESPOSTANOK;
        } else {
            professorRepository.deleteById(professorDeletar.get().getId());
            return RESPOSTAOK;
        }
    }


    //criado um metodo/funcao para converter o dto para entity
    private ProfessorEntity converterEntity(ProfessorDto professorDto) {
        ProfessorEntity professor = new ProfessorEntity();
        professor.setId(professorDto.getId());
        professor.setNome(professorDto.getNome());
        professor.setCpf(professorDto.getCpf());
        professor.setEstadoCivil(professorDto.getEstadoCivil());
        professor.setCargo(professorDto.getCargo());
        professor.setSalario(professorDto.getSalario());
        professor.setDataInicioEmpresa(professorDto.getDataInicioEmpresa());
        return professor;
    }

    //criado um metodo/funcao para converter o entity para dto

    /**
     *
     * @param professorEntity
     * @return
     */
    private ProfessorDto converterDto(ProfessorEntity professorEntity) {
        ProfessorDto professor = new ProfessorDto();
        professor.setId(professorEntity.getId());
        professor.setNome(professorEntity.getNome());
        professor.setCpf(professorEntity.getCpf());
        professor.setEstadoCivil(professorEntity.getEstadoCivil());
        professor.setCargo(professorEntity.getCargo());
        professor.setSalario(professorEntity.getSalario());
        professor.setDataInicioEmpresa(professorEntity.getDataInicioEmpresa());
        return professor;
    }
}
