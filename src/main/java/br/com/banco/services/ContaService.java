package br.com.banco.services;

import br.com.banco.entities.Conta;
import br.com.banco.entities.DTO.ContaGetDTO;
import br.com.banco.entities.DTO.ContaPostDTO;
import br.com.banco.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContaService {

    @Autowired
    ContaRepository repo;

    public void add(ContaPostDTO data){
        if (repo.findByNomeResponsavel(data.getNomeResponsavel()).isPresent()){
            throw new RuntimeException("Responsável já possui conta");
        }
        Conta c = new Conta(data);
        repo.save(c);
    }

    public List<ContaGetDTO> getAllContas(Pageable pageable){
        return repo.findAll(pageable).stream().map(ContaGetDTO::new).collect(Collectors.toList());
    }

    public List<ContaGetDTO> getAllContas(){
        return repo.findAll().stream().map(ContaGetDTO::new).collect(Collectors.toList());
    }

    public Optional<Conta> getByName(String name){
        return repo.findByNomeResponsavel(name);
    }

    public Optional<Conta> getById (Long id){
        return Optional.of(repo.getById(id));
    }

    public void deleteById(Long id){
        repo.deleteById(id);
    }


}
