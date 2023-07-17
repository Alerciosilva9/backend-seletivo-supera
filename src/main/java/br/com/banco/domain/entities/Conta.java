package br.com.banco.domain.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Conta {
    @Id
    private long id_conta;

    //NOT NULL
    private String nome_responsavel;

    public long getId_conta() {
        return id_conta;
    }

    public void setId_conta(long id_conta) {
        this.id_conta = id_conta;
    }

    public String getNome_responsavel() {
        return nome_responsavel;
    }

    public void setNome_responsavel(String nome_responsavel) {
        this.nome_responsavel = nome_responsavel;
    }
}
