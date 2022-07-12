package udemy.nelio.cursojavaangular.services;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udemy.nelio.cursojavaangular.domain.Categoria;
import udemy.nelio.cursojavaangular.repository.CategoriaRepository;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria find(Integer id){
        Optional<Categoria> obj = repo.findById(id);

        return obj.orElseThrow(()-> new ObjectNotFoundException(null,
                "Objeto nao encontrado! Id "+ id+ ",tipo :"+ Categoria.class.getName()));
    }
}
