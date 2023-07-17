package br.com.banco.entities.DTO;

import br.com.banco.entities.Conta;
import br.com.banco.entities.Transferencia;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransferenciaGetDTO {
    private Long id;
    private String nome_operador_transacao;
    private String tipo;
    private LocalDateTime data_transferencia;
    private long id_conta;

    public TransferenciaGetDTO(Transferencia transferencia){
        this.id = transferencia.getId();
        this.nome_operador_transacao = transferencia.getNome_operador_transacao();
        this.tipo = transferencia.getTipo();
        this. data_transferencia = transferencia.getData_transferencia();
        this.id_conta = transferencia.getId();
    }

}
