package udemy.nelio.cursojavaangular.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import udemy.nelio.cursojavaangular.DTO.ClienteDTO;
import udemy.nelio.cursojavaangular.DTO.ClienteNewDTO;
import udemy.nelio.cursojavaangular.domain.cliente.Cliente;
import udemy.nelio.cursojavaangular.services.ClienteService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResources {
    @Autowired
    private ClienteService serv;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> find(@PathVariable Integer id){
         Cliente result = serv.find(id);
         return ResponseEntity.ok(result);
         }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody ClienteDTO objDTO,@PathVariable Integer id){
        Cliente obj = serv.fromDTO(objDTO);
        obj.setId(id);
        serv.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        serv.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public  ResponseEntity<List<ClienteDTO>> findAll(){
        List<Cliente> list = serv.findAll();
        List<ClienteDTO> listDTO = list.stream().map(obj-> new ClienteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping(value ="/page" )
    public  ResponseEntity<Page<ClienteDTO>> findPage(@RequestParam(value ="page", defaultValue = "0")Integer page,
                                                        @RequestParam(value ="linesPerPage", defaultValue = "24")Integer linesPerPage,
                                                        @RequestParam(value ="orderBy", defaultValue = "id") String orderBy,
                                                        @RequestParam(value ="direction", defaultValue = "ASC")String direction){
        Page<Cliente> list = serv.findPage(page,linesPerPage,orderBy,direction);
        Page<ClienteDTO> listDTO = list.map(obj-> new ClienteDTO(obj));
        return ResponseEntity.ok().body(listDTO);
    }
    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody ClienteNewDTO objDTO){
        Cliente obj = serv.fromDTO(objDTO);
        serv.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
