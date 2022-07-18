package udemy.nelio.cursojavaangular.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udemy.nelio.cursojavaangular.domain.pedido.ItemPedido;
import udemy.nelio.cursojavaangular.domain.pedido.PagamentoComBoleto;
import udemy.nelio.cursojavaangular.domain.pedido.Pedido;
import udemy.nelio.cursojavaangular.enums.EstadoPagamento;
import udemy.nelio.cursojavaangular.exception.ObjectNotFoundException;
import udemy.nelio.cursojavaangular.repository.ItemPedidoRepository;
import udemy.nelio.cursojavaangular.repository.PagamentoRepository;
import udemy.nelio.cursojavaangular.repository.PedidoRepository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    @Autowired
    private BoletoService boletoService;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private JogoService produtoService;

    public Pedido find(Integer id){
        Optional<Pedido> obj = repo.findById(id);

        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Objeto nao encontrado! Id "+ id+ ",tipo :"+ Pedido.class.getName()));
    }
    @Transactional
    public Pedido insert(Pedido obj) {
        obj.setId(null);
        obj.setInstante(new Date());
        obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
        obj.getPagamento().setPedido(obj);
        if (obj.getPagamento() instanceof PagamentoComBoleto) {
            PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
            boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
        }
        obj = repo.save(obj);
        pagamentoRepository.save(obj.getPagamento());
        for (ItemPedido ip : obj.getItens()) {
            ip.setDesconto(0.0);
            ip.setPreco(produtoService.find(ip.getProduto().getId()).getPrice());
            ip.setPedido(obj);
        }
        itemPedidoRepository.saveAll(obj.getItens());
        return obj;
    }
}
