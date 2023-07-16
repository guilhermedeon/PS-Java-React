package br.com.banco.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table (name = "transferencia")
@Getter
@Setter
@EqualsAndHashCode (of= "id")
public class Transferencia {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime data_transferencia;
    private BigDecimal valor;
    private String tipo;
    private String nome_operador_transacao;
    @ManyToOne
    private Conta conta;
}
