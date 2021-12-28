package br.com.apirestaurante.Service;


import br.com.apirestaurante.Entity.Mesa;
import br.com.apirestaurante.Entity.Restaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;

@Service
public class RestauranteService {

    Restaurante restaurante = new Restaurante();


    @Autowired
    private MesaService mesaService;

    public Restaurante fecharMesa(long idMesa) {
        Mesa mesa = mesaService.buscaMesa(idMesa);
        restaurante.setCaixa(restaurante.getCaixa().add(mesa.getValorTotalConsumido()));
        mesaService.mesaList.removeIf(m -> m.getId() == idMesa);
        return restaurante;
    }

    public Restaurante saldoCaixa() {
        return restaurante;
    }
}
