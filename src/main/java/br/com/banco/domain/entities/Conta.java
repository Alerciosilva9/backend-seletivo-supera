package br.com.banco.domain.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Conta {
    @Id
    private long id;

    //NOT NULL
    private String nome_responsavel;
}
