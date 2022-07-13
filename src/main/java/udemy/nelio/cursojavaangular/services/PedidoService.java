package udemy.nelio.cursojavaangular.services;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udemy.nelio.cursojavaangular.domain.pedido.Pedido;
import udemy.nelio.cursojavaangular.repository.PedidoRepository;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    public Pedido find(Integer id){
        Optional<Pedido> obj = repo.findById(id);

        return obj.orElseThrow(()-> new ObjectNotFoundException(null,
                "Objeto nao encontrado! Id "+ id+ ",tipo :"+ Pedido.class.getName()));
    }
}
