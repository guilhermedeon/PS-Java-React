package br.com.banco.repositories;

import br.com.banco.entities.Transferencia;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
    public List<Transferencia> getAllByDataTransferenciaBetween(LocalDateTime init, LocalDateTime end);
}