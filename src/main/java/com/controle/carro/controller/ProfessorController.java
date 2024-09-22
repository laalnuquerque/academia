package com.mentoriajava.academia.controller;

import com.mentoriajava.academia.model.dto.ProfessorDto;
import com.mentoriajava.academia.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.mentoriajava.academia.model.enums.Respostas.*;

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
        if (professorService.cadastrar(professorDto).equals(RESPOSTAOK)) {
            return ResponseEntity.status(HttpStatus.OK).body(CADASTRADO_COM_SUCESSO);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ENCONTRADO);
        }
    }

    //@pathvariable faz a ligacao do id do mapping que eh o mesmo id que Long id
    //produces faz o spring dizer que vai devolver um json
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity consultar(@PathVariable(name = "id") String cpf) {
        if (professorService.consultar(cpf).equals(RESPOSTANOK)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MENSAGEMNOK);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(professorService.consultar(cpf));
        }
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> atualizar(@RequestBody ProfessorDto professorDto) {
        if (professorService.atualizar(professorDto).equals(RESPOSTANOK)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MENSAGEMNOK);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(CADASTRO_ATUALIZADO_COM_SUCESSO);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable(name = "id") String cpf) {
        if (professorService.deletar(cpf).equals(RESPOSTANOK)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(MENSAGEMNOK);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(DELETADO);
        }
    }

}
