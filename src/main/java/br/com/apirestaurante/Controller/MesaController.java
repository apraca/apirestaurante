package br.com.apirestaurante.Controller;

import br.com.apirestaurante.Entity.Mesa;
import br.com.apirestaurante.Entity.Restaurante;
import br.com.apirestaurante.Service.MesaService;
import br.com.apirestaurante.Service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/mesa")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    @Autowired
    private RestauranteService restauranteService;

    @PostMapping("/salva")
    public Mesa salva(@RequestBody Mesa mesa) {
        return mesaService.salva(mesa);
    }

    @GetMapping("/{idMesa}")
    public Mesa getPedidosMesa(@PathVariable long idMesa) {
        return mesaService.buscaMesa(idMesa);
    }

    @GetMapping("/fecha/{idMesa}")
    public Restaurante fechaMesa(@PathVariable long idMesa) {
        return restauranteService.fecharMesa(idMesa);
    }

}
