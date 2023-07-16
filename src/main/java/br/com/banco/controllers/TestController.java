package br.com.banco.controllers;

import br.com.banco.repositories.ContaRepository;
import br.com.banco.repositories.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    ContaRepository contaRepository;

    @Autowired
    TransferenciaRepository transferenciaRepository;

    @GetMapping("/users/")
    public ResponseEntity getAllUsers(){
        return ResponseEntity.ok(contaRepository.findAll());
    }

}
