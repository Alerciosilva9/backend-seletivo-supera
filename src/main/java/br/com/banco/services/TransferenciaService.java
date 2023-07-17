package br.com.banco.services;


import br.com.banco.domain.dtos.TransferenciaDTO;
import br.com.banco.domain.entities.Conta;
import br.com.banco.domain.entities.Transferencia;
import br.com.banco.repositories.ContaRepository;
import br.com.banco.repositories.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransferenciaService {

    @Autowired
    TransferenciaRepository transferenciaRepository;

    @Autowired
    ContaRepository contaRepository;

    public List<TransferenciaDTO> buscarTransferencias(Long id, LocalDate inicio, LocalDate fim, String nomeOperador){

        Optional<Conta> conta = contaRepository.findById(id);
        List<Transferencia> lista = new ArrayList<>();

        if(conta.isPresent()){
            if(inicio!=null && fim!=null && nomeOperador!=null){
                lista = transferenciaRepository.findByContaAndOperadorAndDataTransferenciaBetween(conta.get(),nomeOperador,inicio,fim);
                return lista.stream().map(i-> new TransferenciaDTO(i)).collect(Collectors.toList());
            }
            if(inicio!=null && fim!=null){
                lista = transferenciaRepository.findByContaAndDataTransferenciaBetween(conta.get(),inicio,fim);
                return lista.stream().map(i-> new TransferenciaDTO(i)).collect(Collectors.toList());
            }
            if(nomeOperador!=null){
                lista = transferenciaRepository.findByContaAndOperador(conta.get(),nomeOperador);
                return lista.stream().map(i-> new TransferenciaDTO(i)).collect(Collectors.toList());
            }
            lista = transferenciaRepository.findByConta(conta.get());
            return lista.stream().map(i-> new TransferenciaDTO(i)).collect(Collectors.toList());
        }

        return null;
    }

    public List<TransferenciaDTO> buscarTodos(){
        return
                transferenciaRepository.findAll().stream().map(i->new TransferenciaDTO(i)).collect(Collectors.toList());
    }


}
