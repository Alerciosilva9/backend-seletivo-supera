package br.com.banco.domain.entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "transferencia")
public class Transferencia {

    @Id
    private long id;
    //NOT NULL
    private LocalDateTime data_tranferencia;
    //NOT NULL
    private float valor;
   //NOT NULL
    private String tipo;

    private String nome_operador_transacao;

    @ManyToOne
    private Conta conta;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getData_tranferencia() {
        return data_tranferencia;
    }

    public void setData_tranferencia(LocalDateTime data_tranferencia) {
        this.data_tranferencia = data_tranferencia;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome_operador_transacao() {
        return nome_operador_transacao;
    }

    public void setNome_operador_transacao(String nome_operador_transacao) {
        this.nome_operador_transacao = nome_operador_transacao;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}