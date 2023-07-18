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
    @Column(name = "nome_operador_transacao")
    private String nomeOperadorTransacao;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    @JsonBackReference
    private Conta conta;

    public Transferencia(TransferenciaPostDTO data){
        this.dataTransferencia = LocalDateTime.now();
        this.valor = data.getValor();
        this.tipo = data.getTipo();
        this.nomeOperadorTransacao = data.getNomeOperadorTransacao();
    }

}
