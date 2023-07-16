package br.com.banco.services;


import br.com.banco.domain.entities.Conta;
import br.com.banco.domain.entities.Transferencia;
import br.com.banco.repositories.ContaRepository;
import br.com.banco.repositories.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TransferenciaService {

    @Autowired
    TransferenciaRepository transferenciaRepository;

    @Autowired
    ContaRepository contaRepository;

    public List<Transferencia> buscarTransferencias(Long id, LocalDate inicio, LocalDate fim, String nomeOperador){

        Optional<Conta> conta = contaRepository.findById(id);

        if(conta.isPresent()){
            if(inicio!=null && fim!=null && nomeOperador!=null){
                return transferenciaRepository.findByContaAndOperadorAndDataTransferenciaBetween(conta.get(),nomeOperador,inicio,fim);
            }
            if(inicio!=null && fim!=null){
                return transferenciaRepository.findByContaAndDataTransferenciaBetween(conta.get(),inicio,fim);
            }
            if(nomeOperador!=null){
                return transferenciaRepository.findByContaAndOperador(conta.get(),nomeOperador);
            }

            return transferenciaRepository.findByConta(conta.get());
        }

        return null;
    }

    public List<Transferencia> buscarTodos(){
        return transferenciaRepository.findAll();
    }


}
