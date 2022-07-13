package udemy.nelio.cursojavaangular.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import udemy.nelio.cursojavaangular.domain.pedido.ItemPedido;
import udemy.nelio.cursojavaangular.domain.produto.Categoria;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {




}
