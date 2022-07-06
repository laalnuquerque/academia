package com.mentoriajava.academia.services;

import com.mentoriajava.academia.model.dto.ProfessorDto;
import com.mentoriajava.academia.model.entities.ProfessorEntity;
import com.mentoriajava.academia.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public String cadastrar(ProfessorDto professorDto){
        ProfessorEntity professor = converterEntity(professorDto);
        Optional<ProfessorEntity> professorBuscar = professorRepository.findByCpf(professor.getCpf());
        if (professorBuscar.isEmpty()) {
            professorRepository.save(professor);
            return RESPOSTAOK;
        } else {
            return RESPOSTANOK;
        }
    }

    public Object consultar(String cpf){
        //verificar o que o findbyId esta retornando e criar ele para retornar o que busquei
        Optional<ProfessorEntity> professorResultado = professorRepository.findByCpf(cpf);
        if (professorResultado.isEmpty()) {
            return RESPOSTANOK;
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
