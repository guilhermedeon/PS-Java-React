package br.com.banco.entities.DTO;

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
    private String nomeOperadorTransacao;
    private String tipo;
    private LocalDateTime dataTransferencia;
    private long id_conta;

    public TransferenciaGetDTO(Transferencia transferencia){
        this.id = transferencia.getId();
        this.nomeOperadorTransacao = transferencia.getNomeOperadorTransacao();
        this.tipo = transferencia.getTipo();
        this.dataTransferencia = transferencia.getDataTransferencia();
        this.id_conta = transferencia.getId();
    }

}
