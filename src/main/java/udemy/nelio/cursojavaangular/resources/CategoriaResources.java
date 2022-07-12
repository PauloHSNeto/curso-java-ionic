package udemy.nelio.cursojavaangular.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import udemy.nelio.cursojavaangular.domain.Categoria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {

    @GetMapping
    public List<Categoria> listar(){
        Categoria cat1 = new Categoria(1,"RPG");
        Categoria cat2 = new Categoria(2,"Strategy");
        List<Categoria> catList = new ArrayList<Categoria>();
        catList.add(cat1);
        catList.add(cat2);
        return catList;
            }
}
