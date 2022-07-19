package udemy.nelio.cursojavaangular.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import udemy.nelio.cursojavaangular.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import udemy.nelio.cursojavaangular.DTO.ClienteDTO;
import udemy.nelio.cursojavaangular.DTO.ClienteNewDTO;
import udemy.nelio.cursojavaangular.domain.cliente.Cidade;
import udemy.nelio.cursojavaangular.domain.cliente.Cliente;
import udemy.nelio.cursojavaangular.domain.cliente.Endereco;
import udemy.nelio.cursojavaangular.enums.TipoCliente;
import udemy.nelio.cursojavaangular.exception.DataIntegrityException;
import udemy.nelio.cursojavaangular.repository.CidadeRepository;
import udemy.nelio.cursojavaangular.repository.ClienteRepository;
import udemy.nelio.cursojavaangular.repository.EnderecoRepository;


import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;
    @Autowired
    private CidadeRepository cidRepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private EnderecoRepository endRepo;

    public Cliente find(Integer id){
        Optional<Cliente> obj = repo.findById(id);

        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Objeto nao encontrado! Id "+ id+ ",tipo :"+ Cliente.class.getName()));
    }
    public Cliente update(Cliente obj) {
        Cliente newObj = find(obj.getId());
        updateData(newObj,obj);
        return repo.save(newObj);
    }

    private void updateData(Cliente newObj, Cliente obj) {
        newObj.setNome(obj.getNome());
        newObj.setEmail(obj.getEmail());
    }

    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Nao e possivel excluir por que ha entidades relacionadas");

        }
    }
    public List<Cliente> findAll(){
        return repo.findAll();
    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction),
                orderBy);
        return repo.findAll(pageRequest);
    }

    public Cliente fromDTO(ClienteDTO objDto) {
        return new Cliente(objDto.getId(), objDto.getName(), objDto.getEmail(), null, null,null);
    }
    public Cliente fromDTO(ClienteNewDTO objDto) {
        Cliente cli = new Cliente(null, objDto.getName(), objDto.getEmail(), objDto.getCpfOuCnpj(), TipoCliente.toEnum(objDto.getTipo()) , bCryptPasswordEncoder.encode(objDto.getSenha()));
        Cidade cid = new Cidade(objDto.getCidadeId(), null, null);
        Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), cli, cid);
        cli.getEnderecos().add(end);
        cli.getTelefones().add(objDto.getTelefone1());
        if (objDto.getTelefone2()!=null) {
            cli.getTelefones().add(objDto.getTelefone2());
        }
        if (objDto.getTelefone3()!=null) {
            cli.getTelefones().add(objDto.getTelefone3());
        }
        return cli;
    }
    @Transactional
    public Cliente insert(Cliente obj){
        obj.setId(null);
        obj = repo.save(obj);
        endRepo.saveAll(obj.getEnderecos());
        return obj;
    }
}
