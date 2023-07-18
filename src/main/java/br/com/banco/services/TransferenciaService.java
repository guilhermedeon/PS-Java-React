package br.com.banco.services;

import br.com.banco.entities.DTO.TransferenciaGetDTO;
import br.com.banco.entities.DTO.TransferenciaPostDTO;
import br.com.banco.entities.Transferencia;
import br.com.banco.repositories.ContaRepository;
import br.com.banco.repositories.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransferenciaService {

    @Autowired
    TransferenciaRepository repo;

    @Autowired
    ContaRepository contaRepository;

    public List<TransferenciaGetDTO> getAll() {
        return repo.findAll().stream().map(TransferenciaGetDTO::new).collect(Collectors.toList());
    }

    public List<TransferenciaGetDTO> getAllPaged(Pageable pageable){
        return repo.findAll(pageable).stream().map(TransferenciaGetDTO::new).collect(Collectors.toList());
    }

    public Optional<TransferenciaGetDTO> getById(Long id) {
        return Optional.of(new TransferenciaGetDTO(repo.findById(id).get()));
    }

}
