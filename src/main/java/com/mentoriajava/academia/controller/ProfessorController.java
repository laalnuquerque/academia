package com.mentoriajava.academia.controller;

import com.mentoriajava.academia.model.dto.ProfessorDto;
import com.mentoriajava.academia.repository.ProfessorRepository;
import com.mentoriajava.academia.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    public void cadastrar(@RequestBody ProfessorDto professorDto) {
        professorService.cadastrar(professorDto);
    }

    @GetMapping
    public String consultar(ProfessorDto professorDto) {
        return "teste de verbos http";
    }

}
