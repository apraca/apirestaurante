package br.com.apirestaurante.Service;


import br.com.apirestaurante.Entity.Pedido;
import br.com.apirestaurante.Entity.Prato;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PedidoService {


    public BigDecimal calculaValorTotal(List<Prato> pratos) {
        BigDecimal valorTotal = BigDecimal.valueOf(0);
        for (Prato p : pratos) {
            BigDecimal valor = p.getPreco().multiply(BigDecimal.valueOf(p.getQuantidade()));
            valorTotal = valorTotal.add(valor);
        }
        return valorTotal;
    }

}
