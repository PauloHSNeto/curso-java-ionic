package udemy.nelio.cursojavaangular.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import udemy.nelio.cursojavaangular.domain.Estado;
import udemy.nelio.cursojavaangular.domain.Jogo;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
