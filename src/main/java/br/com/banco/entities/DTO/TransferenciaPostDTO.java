package br.com.banco.entities.DTO;

import br.com.banco.entities.Conta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransferenciaPostDTO {
    private String nomeOperadorTransacao;
    private String tipo;
    private Long idConta;
    private float valor;

    public TransferenciaPostDTO(String nomeOperadorTransacao, String tipo, float valor, Long idConta){
        this.nomeOperadorTransacao = nomeOperadorTransacao;
        this.tipo = tipo;
        this.idConta = idConta;
        this.valor = valor;
    }

}
