package udemy.nelio.cursojavaangular.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import udemy.nelio.cursojavaangular.domain.cliente.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
