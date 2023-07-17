package br.com.banco.services;


import br.com.banco.domain.entities.Conta;
import br.com.banco.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {
    @Autowired
    ContaRepository repository;

    public List<Conta> buscarTodas(){
        return repository.findAll();
    }
}
