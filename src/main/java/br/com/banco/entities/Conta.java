package br.com.banco.entities;

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
    private String nome_responsavel;
    @OneToMany(mappedBy = "conta")
    @JsonManagedReference
    private List<Transferencia> transferencias = new ArrayList<>();
    @Transient
    private BigDecimal saldo;

    @PostLoad
    public void postLoad() {
        BigDecimal sum = BigDecimal.ZERO;
        for (Transferencia tr : transferencias){
            sum = sum.add(tr.getValor());
        }
        this.saldo = sum;
    }
}
