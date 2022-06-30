package com.mentoriajava.academia.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDto {
    private long id;
    private String nome;
    private String cpf;
    private String estadoCivil;

}
