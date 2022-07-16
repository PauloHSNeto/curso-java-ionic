package udemy.nelio.cursojavaangular.services;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import udemy.nelio.cursojavaangular.domain.produto.Categoria;
import udemy.nelio.cursojavaangular.domain.produto.Jogo;
import udemy.nelio.cursojavaangular.repository.CategoriaRepository;
import udemy.nelio.cursojavaangular.repository.JogoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JogoService {

    @Autowired
    private JogoRepository repo;
    @Autowired
    private CategoriaRepository catRepo;

    public Jogo find(Integer id){
        Optional<Jogo> obj = repo.findById(id);

        return obj.orElseThrow(()-> new ObjectNotFoundException(null,
                "Objeto nao encontrado! Id "+ id+ ",tipo :"+ Jogo.class.getName()));
    }

    public Page<Jogo> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction),
                orderBy);
        List<Categoria> categorias = catRepo.findAllById(ids);
        return repo.findDistinctByNameContainingAndCategoriasIn(nome,categorias,pageRequest);
    }




}
