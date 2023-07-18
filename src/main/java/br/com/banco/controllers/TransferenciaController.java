package br.com.banco.controllers;

import br.com.banco.entities.Conta;
import br.com.banco.entities.DTO.TransferenciaGetDTO;
import br.com.banco.entities.DTO.TransferenciaPostDTO;
import br.com.banco.entities.Transferencia;
import br.com.banco.services.ContaService;
import br.com.banco.services.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/transferencia")
public class TransferenciaController {

    @Autowired
    TransferenciaService service;


    @GetMapping("/")
    public ResponseEntity getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping("/")
    public ResponseEntity newTransferencia(@RequestBody TransferenciaPostDTO dados, UriComponentsBuilder uriBuilder) {
        return ResponseEntity.ok(service.saveTransferencia(dados));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity getById(Long id){
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping("/data/")
    public ResponseEntity getByData(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime init, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime end){
        return ResponseEntity.ok(service.getByData(init,end));
    }

    @GetMapping("/page/")
    public ResponseEntity getAllPaged(Pageable pageable){
        return ResponseEntity.ok(service.getAllPaged(pageable));
    }



}
