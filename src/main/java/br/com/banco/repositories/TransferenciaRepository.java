package br.com.banco.repositories;

import br.com.banco.domain.entities.Conta;
import br.com.banco.domain.entities.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
    List<Transferencia> findByConta(Conta conta);
    List<Transferencia> findByContaAndDataTransferenciaBetween(Conta conta, LocalDate start, LocalDate end);

    List<Transferencia> findByContaAndOperador(Conta conta, String nome);

    List<Transferencia> findByContaAndOperadorAndDataTransferenciaBetween(Conta conta,String nome ,LocalDate start, LocalDate end);





}