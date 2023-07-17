package br.com.banco.entities.DTO;

import br.com.banco.entities.Conta;
import br.com.banco.entities.Transferencia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContaGetDTO {
    private Long id;
    private String nomeResponsavel;
    private List<Transferencia> transferencias;

    private float saldo;

    public ContaGetDTO(Conta conta) {
        this.id = conta.getId_conta();
        this.nomeResponsavel = conta.getNomeResponsavel();
        this.transferencias = conta.getTransferencias();
        this.saldo = conta.getSaldo();
    }
}
