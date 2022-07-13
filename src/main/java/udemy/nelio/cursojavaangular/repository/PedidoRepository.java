package udemy.nelio.cursojavaangular.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import udemy.nelio.cursojavaangular.domain.pedido.Pedido;
import udemy.nelio.cursojavaangular.domain.produto.Jogo;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
