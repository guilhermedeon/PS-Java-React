package br.com.banco.controllers;

import br.com.banco.entities.DTO.ContaPostDTO;
import br.com.banco.services.ContaService;
import br.com.banco.services.TransferenciaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    ContaService contaService;
    @Autowired
    TransferenciaService transferenciaService;

    @PostMapping("conta/add/")
    public ResponseEntity novaConta(@RequestBody ContaPostDTO data){
        contaService.add(data);
        return ResponseEntity.ok(contaService.getByName(data.getNomeResponsavel()));
    }

    @DeleteMapping("conta/delete/")
    public ResponseEntity deleteConta(@RequestBody Long id){
        contaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("conta/page/")
    public ResponseEntity getAll(@PageableDefault(page = 0, size = 10) Pageable pageable){
        return ResponseEntity.ok(contaService.getAllContas(pageable));
    }

    @GetMapping("conta/todas/")
    public ResponseEntity getAllUnpaged(){
        return ResponseEntity.ok(contaService.getAllContas());
    }

}
