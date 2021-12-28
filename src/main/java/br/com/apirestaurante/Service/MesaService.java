package br.com.apirestaurante.Service;

import br.com.apirestaurante.Controller.repository.MesaRepository;
import br.com.apirestaurante.Entity.Mesa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class MesaService {

    private MesaRepository mesaRepository;
    private Logger logger = null;

    public MesaService(){
        this.mesaRepository = mesaRepository;
        this.logger = LoggerFactory.getLogger(MesaService.class);

    }

    public Mesa salva(Mesa mesa){
        try{
            mesaRepository.salva(mesa);
            logger.debug("mesa salva");
            return mesa;
        }catch (IOException e){
                logger.error(e.getMessage());
        }
        return null;
    }

    public Mesa buscaMesa(Long id){
        return mesaRepository.get(id);
    }



//    @Autowired
//    private PedidoService pedidoService;
//
//
//    List<Mesa> mesaList = new ArrayList<>();
//
//    public Mesa salva(Mesa mesa) {
//        mesa.setValorTotalConsumido(calculaValorTotalConsumido(mesa.getPedidos()));
//        mesa.getPedidos().stream().forEach(pedido -> pedido.setValorTotal(pedidoService.calculaValorTotal(pedido.getPratos())));
//        mesaList.add(mesa);
//        return mesa;
//    }
//
//    public Mesa buscaMesa(long id) {
//        Optional<Mesa> op = mesaList.stream().filter(m -> m.getId()==id).findFirst();
//        return op.orElse(new Mesa());
//    }
//
//    public BigDecimal calculaValorTotalConsumido(List<Pedido> pedidos) {
//        BigDecimal valorTotalConsumido = BigDecimal.valueOf(0);
//        for (Pedido p : pedidos) {
//            for (Prato pr : p.getPratos()) {
//                BigDecimal valor = pr.getPreco().multiply(BigDecimal.valueOf(pr.getQuantidade()));
//                valorTotalConsumido = valorTotalConsumido.add(valor);
//            }
//        }
//        return valorTotalConsumido;
//
//        }
    }
