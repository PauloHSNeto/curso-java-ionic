package udemy.nelio.cursojavaangular.services;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udemy.nelio.cursojavaangular.domain.cliente.Cliente;
import udemy.nelio.cursojavaangular.repository.ClienteRepository;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente find(Integer id){
        Optional<Cliente> obj = repo.findById(id);

        return obj.orElseThrow(()-> new ObjectNotFoundException(null,
                "Objeto nao encontrado! Id "+ id+ ",tipo :"+ Cliente.class.getName()));
    }
}
