package com.mentoriajava.academia.controller;

import com.mentoriajava.academia.model.dto.AlunoDto;
import com.mentoriajava.academia.services.AlunoService;
import com.mentoriajava.academia.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
