package udemy.nelio.cursojavaangular.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import udemy.nelio.cursojavaangular.domain.produto.Categoria;
import udemy.nelio.cursojavaangular.domain.produto.Jogo;

import java.util.List;

import static org.hibernate.hql.internal.antlr.HqlTokenTypes.LIKE;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Integer> {

    @Transactional(readOnly=true)
    Page<Jogo> findDistinctByNameContainingAndCategoriasIn(
            String name,
            List<Categoria> categorias,
            Pageable pageRequest);

}
