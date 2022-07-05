package com.mentoriajava.academia.controller;

import com.mentoriajava.academia.model.dto.ProfessorDto;
import com.mentoriajava.academia.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.mentoriajava.academia.model.enums.Respostas.RESPOSTAOK;
import static com.mentoriajava.academia.model.enums.Respostas.RESPOSTANOK;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    private ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    //spring so aceita se tiver o json/informacao
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity cadastrar(@RequestBody ProfessorDto professorDto) {
        return professorService.cadastrar(professorDto);
    }

    //@pathvariable faz a ligacao do id do mapping que eh o mesmo id que Long id
    //produces faz o spring dizer que vai devolver um json
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ProfessorDto consultar(@PathVariable(name = "id") String cpf) {

        return professorService.consultar(cpf);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> atualizar(@RequestBody ProfessorDto professorDto) {
        if (professorService.atualizar(professorDto).equals(RESPOSTANOK)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Professor nao cadastrado");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("Cadastro atualizado com sucesso");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable(name = "id") String cpf) {
        if (professorService.deletar(cpf).equals(RESPOSTANOK)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Professor nao cadastrado");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("Professor deletado com sucesso");
        }
    }

}
