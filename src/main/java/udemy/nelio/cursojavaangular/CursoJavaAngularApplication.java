package udemy.nelio.cursojavaangular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import udemy.nelio.cursojavaangular.domain.*;
import udemy.nelio.cursojavaangular.enums.TipoCliente;
import udemy.nelio.cursojavaangular.repository.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CursoJavaAngularApplication implements CommandLineRunner {
    @Autowired
    private CategoriaRepository catrepo;
    @Autowired
    private JogoRepository jogoRepo;
    @Autowired
    private CidadeRepository cidrepo;
    @Autowired
    private EstadoRepository estrepo;
    @Autowired
    private ClienteRepository cliRepo;
    @Autowired
    private EnderecoRepository endRepo;


    public static void main(String[] args) {
        SpringApplication.run(CursoJavaAngularApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria(null, "RPG");
        Categoria cat2 = new Categoria(null, "Strategy");
        Categoria cat3 = new Categoria(null, "Adventure");
        Categoria cat4 = new Categoria(null, "Shooter");
        Categoria cat5 = new Categoria(null, "Online");
        Categoria cat6 = new Categoria(null, "Horror");
        Categoria cat7 = new Categoria(null, "Puzzle");
        Categoria cat8 = new Categoria(null, "Sport");
        Categoria cat9 = new Categoria(null, "Novel");

        catrepo.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5,cat6,cat7,cat8,cat9));

        Jogo jogo1 = new Jogo(null,"Skyrim",60.00);
        Jogo jogo2 = new Jogo(null, "Starcraft", 50.00);
        Jogo jogo3 = new Jogo(null, "Mass Effect", 70.00);
        Jogo jogo4 = new Jogo(null,"Fire Emblem",60.00);
        Jogo jogo5 = new Jogo(null, "Zelda", 50.00);
        Jogo jogo6 = new Jogo(null, "X-COM", 70.00);

        cat1.getJogos().addAll(Arrays.asList(jogo1,jogo3));
        cat2.getJogos().addAll(Arrays.asList(jogo2));
        jogo1.getCategorias().add(cat1);
        jogo2.getCategorias().add(cat2);
        jogo3.getCategorias().addAll(Arrays.asList(cat1,cat3));

        jogoRepo.saveAll(Arrays.asList(jogo1,jogo2,jogo3));

        Estado est1 = new Estado(null,"Rio de Janeiro");
        Estado est2 = new Estado(null,"Sao Paulo");

        Cidade cid1 = new Cidade(null, "Osasco",est1);
        Cidade cid2 = new Cidade(null, "Niteroi",est2);
        Cidade cid3 = new Cidade (null,"Curitiba",est1);

        estrepo.saveAll(Arrays.asList(est1,est2));
        cidrepo.saveAll(Arrays.asList(cid1,cid2,cid3));


        Cliente cli1 = new Cliente(null, "Paulo Henrique","paulo@otmail.com","33333333333", TipoCliente.PESSOAFISICA);
        cli1.getTelefones().addAll(Arrays.asList("12121212","34343434","45454545"));

        Endereco end1 = new Endereco(null,"logarouro","111","apt 11 bloco 1", "bairro","cep",cli1, cid1 );
        Endereco end2 = new Endereco(null,"logarouro2","1112","apt 112 bloco 12", "bairro2","cep2",cli1, cid2 );

        cli1.getEnderecos().addAll(Arrays.asList(end1,end2));

        cliRepo.saveAll(Arrays.asList(cli1));
        endRepo.saveAll(Arrays.asList(end1,end2));








    }
}
