package com.mentoriajava.academia.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_aluno")
public class AlunoEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String nome;

    @Column
    private String cpf;

    @Column
    private String estadoCivil;

    @Column
    private Date dataMatricula;

    @Column
    private String nivel;
}
