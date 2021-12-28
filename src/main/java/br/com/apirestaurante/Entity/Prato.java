package br.com.apirestaurante.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Prato {
    private long id;
    private BigDecimal preco;
    private String descricao;
    private int quantidade;

}
