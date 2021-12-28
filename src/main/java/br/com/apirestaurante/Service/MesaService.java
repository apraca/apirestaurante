package br.com.apirestaurante.Service;


import br.com.apirestaurante.Entity.Mesa;
import br.com.apirestaurante.Entity.Pedido;
import br.com.apirestaurante.Entity.Prato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MesaService {

    @Autowired
    private PedidoService pedidoService;


    List<Mesa> mesaList = new ArrayList<>();

    public Mesa salva(Mesa mesa) {
        mesa.setValorTotalConsumido(calculaValorTotalConsumido(mesa.getPedidos()));
        mesa.getPedidos().stream().forEach(pedido -> pedido.setValorTotal(pedidoService.calculaValorTotal(pedido.getPratos())));
        mesaList.add(mesa);
        return mesa;
    }

    public Mesa buscaMesa(long id) {
        Optional<Mesa> op = mesaList.stream().filter(m -> m.getId()==id).findFirst();
        return op.orElse(new Mesa());
    }

    public BigDecimal calculaValorTotalConsumido(List<Pedido> pedidos) {
        BigDecimal valorTotalConsumido = BigDecimal.valueOf(0);
        for (Pedido p : pedidos) {
            for (Prato pr : p.getPratos()) {
                BigDecimal valor = pr.getPreco().multiply(BigDecimal.valueOf(pr.getQuantidade()));
                valorTotalConsumido = valorTotalConsumido.add(valor);
            }
        }
        return valorTotalConsumido;

        }
    }
