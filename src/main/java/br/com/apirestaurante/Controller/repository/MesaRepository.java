package br.com.apirestaurante.Controller.repository;

import br.com.apirestaurante.Entity.Mesa;
import br.com.apirestaurante.Entity.Pedido;
import br.com.apirestaurante.Entity.Prato;
import br.com.apirestaurante.Service.PedidoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Component
public class MesaRepository implements OurRepository<Mesa, Long>{

    @Autowired
    private PedidoService pedidoService;

    List<Mesa> mesaList = new ArrayList<>();
    private Mesa mesa = new Mesa();
    private ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    private final String PATH = "mesa.json";

    public void salva(Mesa mesa) throws IOException {
        mesa.setId((long) mesaList.size()+1);
        mesa.setValorTotalConsumido(calculaValorTotalConsumido(mesa.getPedidos()));
        mesa.getPedidos().stream().forEach(pedido -> pedido.setValorTotal(pedidoService.calculaValorTotal(pedido.getPratos())));
        mesaList.add(mesa);
        objectMapper.writeValue(new File(PATH), mesaList);
    }

    @Override
    public Mesa buscaMesa() throws IOException {
        return null;
    }



    public List<Mesa> busca() throws IOException {
        File file = new File(PATH);
        FileInputStream is = new FileInputStream(file);
        mesaList = Arrays.asList(objectMapper.readValue(is, Mesa[].class));

        return mesaList;
    }


    public Mesa get(Long id) {
        Optional<Mesa> optional = mesaList.stream().filter(m -> m.getId() == id ).findAny();
        return optional.orElse(new Mesa());
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
