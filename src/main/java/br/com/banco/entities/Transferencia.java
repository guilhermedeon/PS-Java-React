package br.com.banco.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table (name = "transferencia")
@Getter
@Setter
@EqualsAndHashCode (of= "id")
@AllArgsConstructor
@NoArgsConstructor

public class Transferencia {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime data_transferencia;
    private float valor;
    private String tipo;
    private String nome_operador_transacao;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    @JsonBackReference
    private Conta conta;

}
