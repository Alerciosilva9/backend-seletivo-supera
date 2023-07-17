package br.com.banco.domain.dtos;

import br.com.banco.domain.entities.Transferencia;

import java.time.LocalDate;

public class TransferenciaDTO {
    private Long id;
    private LocalDate dataTransferencia;

    private Float valor;

    private String tipo;

    private String operador;



    public TransferenciaDTO(){

    }

    public TransferenciaDTO(Transferencia transferencia){
        this.id = transferencia.getId();
        this.dataTransferencia = transferencia.getDataTransferencia();
        this.operador = transferencia.getOperador();
        this.tipo = transferencia.getTipo();
        this.valor = transferencia.getValor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(LocalDate dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }
}
