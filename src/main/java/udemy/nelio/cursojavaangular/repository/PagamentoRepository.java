package udemy.nelio.cursojavaangular.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import udemy.nelio.cursojavaangular.domain.pedido.Pagamento;
import udemy.nelio.cursojavaangular.domain.pedido.Pedido;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
}
