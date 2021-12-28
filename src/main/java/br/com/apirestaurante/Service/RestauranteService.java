package br.com.apirestaurante.Service;


import br.com.apirestaurante.Entity.Mesa;
import br.com.apirestaurante.Entity.Restaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestauranteService {

    Restaurante restaurante = new Restaurante();


    @Autowired
    private MesaService mesaService;

    public Restaurante fecharMesa(long idMesa) {
        Mesa mesa = mesaService.buscaMesa(idMesa);
        restaurante.setCaixa(restaurante.getCaixa().add(mesa.getValorTotalConsumido()));

        return restaurante;
    }

    public Restaurante saldoCaixa() {
        return restaurante;
    }
}
