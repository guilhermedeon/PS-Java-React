package br.com.banco.entities;

import br.com.banco.entities.DTO.ContaPostDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "conta")
@Getter
@Setter
@EqualsAndHashCode (of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Conta {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id_conta;
    @Column (name = "nome_responsavel")
    private String nomeResponsavel;
    @OneToMany(mappedBy = "conta")
    @JsonManagedReference
    private List<Transferencia> transferencias = new ArrayList<>();
    @Transient
    private float saldo;

    public Conta(ContaPostDTO data){
        this.nomeResponsavel = data.getNomeResponsavel();
    }


    @PostLoad
    public void postLoad() {
        float sum = 0;
        for (Transferencia tr : transferencias){
            sum = sum + tr.getValor();
        }
        this.saldo = (float) Math.floor(sum * 100) / 100;
    }
}
