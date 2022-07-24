package udemy.nelio.cursojavaangular.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import udemy.nelio.cursojavaangular.DTO.CategoriaDTO;
import udemy.nelio.cursojavaangular.domain.produto.Categoria;
import udemy.nelio.cursojavaangular.services.CategoriaService;

import javax.servlet.Servlet;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {
    @Autowired
    private CategoriaService serv;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> find(@PathVariable Integer id){
         Categoria result = serv.find(id);
         return ResponseEntity.ok(result);
         }
    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Void> instert(@Valid @RequestBody CategoriaDTO objDTO){
        Categoria obj = serv.fromDTO(objDTO);
        obj = serv.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody CategoriaDTO objDTO,@PathVariable Integer id){
        Categoria obj = serv.fromDTO(objDTO);
        obj.setId(id);
        serv.update(obj);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        serv.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public  ResponseEntity<List<CategoriaDTO>> findAll(){
        List<Categoria> list = serv.findAll();
        List<CategoriaDTO> listDTO = list.stream().map(obj-> new CategoriaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value ="/page" )
    public  ResponseEntity<Page<CategoriaDTO>> findPage(@RequestParam(value ="page", defaultValue = "0")Integer page,
                                                       @RequestParam(value ="linesPerPage", defaultValue = "24")Integer linesPerPage,
                                                       @RequestParam(value ="orderBy", defaultValue = "id") String orderBy,
                                                       @RequestParam(value ="direction", defaultValue = "ASC")String direction){
        Page<Categoria> list = serv.findPage(page,linesPerPage,orderBy,direction);
        Page<CategoriaDTO> listDTO = list.map(obj-> new CategoriaDTO(obj));
        return ResponseEntity.ok().body(listDTO);
    }
}
