package com.mentoriajava.academia.controller;

import com.mentoriajava.academia.model.dto.AlunoDto;
import com.mentoriajava.academia.services.AlunoService;
import com.mentoriajava.academia.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mentoriajava.academia.model.enums.Respostas.*;
@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private AlunoService alunoService;

    @Autowired
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity cadastrar(@RequestBody AlunoDto alunoDto){
        if (alunoService.cadastrar(alunoDto).equals(RESPOSTANOK)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ENCONTRADO);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(CADASTRADO_COM_SUCESSO);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity consultar(@PathVariable(name = "id") String nivel){
        if (alunoService.consultarNivel(nivel) == null ){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RESPOSTANOK);
        } else {
            return ResponseEntity.ok((alunoService.consultarNivel(nivel)));
            //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ENCONTRADO);
        }
    }

}
