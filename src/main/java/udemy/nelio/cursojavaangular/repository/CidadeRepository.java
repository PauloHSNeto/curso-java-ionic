package udemy.nelio.cursojavaangular.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import udemy.nelio.cursojavaangular.domain.cliente.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
}
