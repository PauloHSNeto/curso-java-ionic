package udemy.nelio.cursojavaangular.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import udemy.nelio.cursojavaangular.domain.Categoria;
import udemy.nelio.cursojavaangular.domain.Jogo;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Integer> {
}
