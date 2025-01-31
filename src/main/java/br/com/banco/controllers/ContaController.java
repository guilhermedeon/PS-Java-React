package br.com.banco.controllers;

import br.com.banco.entities.DTO.ContaGetDTO;
import br.com.banco.entities.DTO.ContaPostDTO;
import br.com.banco.services.ContaService;
import br.com.banco.services.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    ContaService contaService;

    @PostMapping("/")
    public ResponseEntity novaConta(@RequestBody ContaPostDTO data){
        contaService.add(data);
        return ResponseEntity.ok(new ContaGetDTO(contaService.getByName(data.getNomeResponsavel()).get()));
    }

    @GetMapping("/")
    public ResponseEntity getAllUnpaged(){
        return ResponseEntity.ok(contaService.getAllContas());
    }

    @DeleteMapping("/delete/")
    public ResponseEntity deleteConta(@RequestBody Long id){
        contaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/")
    public ResponseEntity getById(@PathVariable Long id){
        return ResponseEntity.ok(contaService.getById(id));
    }

    @GetMapping("/page/")
    public ResponseEntity getAll(@PageableDefault(page = 0, size = 10) Pageable pageable){
        return ResponseEntity.ok(contaService.getAllContas(pageable));
    }

}
