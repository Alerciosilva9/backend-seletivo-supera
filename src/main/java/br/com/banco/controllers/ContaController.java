package br.com.banco.controllers;

import br.com.banco.domain.entities.Conta;
import br.com.banco.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contas")
@CrossOrigin(origins = "http://localhost:3000")
public class ContaController {

    @Autowired
    ContaService service;
    @GetMapping
    List<Conta> buscarTodas(){
        return service.buscarTodas();
    }
}
