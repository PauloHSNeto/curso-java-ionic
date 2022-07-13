package udemy.nelio.cursojavaangular.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import udemy.nelio.cursojavaangular.domain.produto.Categoria;
import udemy.nelio.cursojavaangular.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {
    @Autowired
    private CategoriaService serv;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> find(@PathVariable Integer id){
         Categoria result = serv.find(id);
         return ResponseEntity.ok(result);
         }
}
