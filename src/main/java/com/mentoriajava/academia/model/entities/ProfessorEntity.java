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
@Table(name = "tb_professor") //definir a tabela
public class ProfessorEntity  implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id") //posso definir um nome
    private Long id;

    @Column(nullable = false)  //define null e notnull, por padrao eh null
    private String nome;

    @Column
    private String cpf;

    @Column
    private String estadoCivil;

    @Column
    private String cargo;

    @Column
    private double salario;

    @Column
    private Date dataInicioEmpresa;

    @Column
    private int tempoDeEmpresa;
}
