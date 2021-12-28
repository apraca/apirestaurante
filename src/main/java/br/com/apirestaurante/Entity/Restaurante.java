package br.com.apirestaurante.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class Restaurante {

    String nome;
    BigDecimal caixa;

    public Restaurante() {
        this.nome = "Restaurante";
        this.caixa = BigDecimal.valueOf(0);
    }
}
