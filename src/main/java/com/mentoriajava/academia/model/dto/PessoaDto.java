package com.mentoriajava.academia.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDto {
    protected int id;
    protected String nome;
    protected String cpf;
    protected String estadoCivil;

}
