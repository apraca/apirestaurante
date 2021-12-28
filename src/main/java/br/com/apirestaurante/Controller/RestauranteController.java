package br.com.apirestaurante.Controller;

import br.com.apirestaurante.Entity.Restaurante;
import br.com.apirestaurante.Service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping("/caixa")
    public Restaurante getCaixa() {
        return restauranteService.saldoCaixa();
    }
}
