package br.com.banco.controllers;

import br.com.banco.domain.dtos.TransferenciaDTO;
import br.com.banco.domain.entities.Conta;
import br.com.banco.domain.entities.Transferencia;
import br.com.banco.repositories.ContaRepository;
import br.com.banco.repositories.TransferenciaRepository;
import br.com.banco.services.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/transferencias")
@CrossOrigin(origins = "http://localhost:3000")
public class TransferenciaController {
    @Autowired
    TransferenciaService service;

    @GetMapping
    public List<TransferenciaDTO> getAll(){
        return service.buscarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<TransferenciaDTO>> getDadosTransferencias(@PathVariable Long id,
                                                                         @RequestParam(name = "inicio",required=false) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate inicio,
                                                                         @RequestParam(name = "fim",required=false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim,
                                                                         @RequestParam(name = "operador",required = false) String nomeOperador){

        List<TransferenciaDTO> transferencias = service.buscarTransferencias(id,inicio,fim,nomeOperador);


        if(transferencias!=null){
            return ResponseEntity.ok().body(transferencias);
        }

        return ResponseEntity.notFound().build();
    }
}
