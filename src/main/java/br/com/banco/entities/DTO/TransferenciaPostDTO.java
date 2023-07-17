package br.com.banco.entities.DTO;

import br.com.banco.entities.Conta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.jni.Local;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransferenciaPostDTO {
    private String nome_operador_transacao;
    private String tipo;
    private LocalDateTime data_transferencia;
    private Long id_conta;
    private float valor;

    public TransferenciaPostDTO(String nome_operador_transacao, String tipo, float valor, Conta conta){
        this.nome_operador_transacao = nome_operador_transacao;
        this.tipo = tipo;
        this.data_transferencia = LocalDateTime.now();
        this.id_conta = conta.getId_conta();
        this.valor = valor;
    }

}
