package br.com.banco.repositories;

import br.com.banco.entities.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    public Optional<Conta> findByNomeResponsavel(String nomeResponsavel);
}