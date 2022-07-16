package udemy.nelio.cursojavaangular.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udemy.nelio.cursojavaangular.DTO.CategoriaDTO;
import udemy.nelio.cursojavaangular.DTO.JogoDTO;
import udemy.nelio.cursojavaangular.domain.produto.Categoria;
import udemy.nelio.cursojavaangular.domain.produto.Jogo;
import udemy.nelio.cursojavaangular.resources.utils.URL;
import udemy.nelio.cursojavaangular.services.JogoService;

import java.util.List;

@RestController
@RequestMapping(value = "/jogos")
public class JogoResources {
    @Autowired
    private JogoService serv;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Jogo> find(@PathVariable Integer id){
         Jogo result = serv.find(id);
         return ResponseEntity.ok(result);
         }
    @GetMapping
    public  ResponseEntity<Page<JogoDTO>> findPage(@RequestParam(value ="page", defaultValue = "0")Integer page,
                                                   @RequestParam(value ="name", defaultValue = "")String name,
                                                   @RequestParam(value ="categorias", defaultValue = "1,2,3,4,5,6,7")String categorias,
                                                   @RequestParam(value ="linesPerPage", defaultValue = "24")Integer linesPerPage,
                                                   @RequestParam(value ="orderBy", defaultValue = "id") String orderBy,
                                                   @RequestParam(value ="direction", defaultValue = "ASC")String direction){
        String nomeDecoded = URL.decodeParam(name);
        List<Integer> ids = URL.decodeIntList(categorias);
        Page<Jogo> list = serv.search(nomeDecoded,ids,page,linesPerPage,orderBy,direction);
        Page<JogoDTO> listDTO = list.map(obj-> new JogoDTO(obj));
        return ResponseEntity.ok().body(listDTO);
    }
}
