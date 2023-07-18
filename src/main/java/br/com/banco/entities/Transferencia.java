package br.com.banco.entities;

import br.com.banco.entities.DTO.TransferenciaPostDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
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
    @Column(name = "data_transferencia")
    private LocalDateTime dataTransferencia;
    private float valor;
    private String tipo;
    private String nome_operador_transacao;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    @JsonBackReference
    private Conta conta;

    public Transferencia(TransferenciaPostDTO data){
        this.dataTransferencia = data.getData_transferencia();
        this.valor = data.getValor();
        this.tipo = data.getTipo();
        this.dataTransferencia = getDataTransferencia();
    }

}
