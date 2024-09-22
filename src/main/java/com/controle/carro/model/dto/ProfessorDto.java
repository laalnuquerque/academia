package com.mentoriajava.academia.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDto extends PessoaDto{
    private String cargo;
    private double salario;
    private Date   dataInicioEmpresa;
}
