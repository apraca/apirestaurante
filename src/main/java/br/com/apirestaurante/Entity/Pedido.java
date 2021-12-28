package br.com.apirestaurante.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    private long id;
    private long idMesa;
    private List<Prato> pratos;
    private BigDecimal valorTotal;
}
