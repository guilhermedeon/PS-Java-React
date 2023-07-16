package br.com.banco.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "conta")
@Getter
@Setter
@EqualsAndHashCode (of = "id")
public class Conta {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome_responsavel;
    @OneToMany (mappedBy = "conta")
    private List<Transferencia> transferencias = new ArrayList<>();
}
