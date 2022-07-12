package udemy.nelio.cursojavaangular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import udemy.nelio.cursojavaangular.domain.Categoria;
import udemy.nelio.cursojavaangular.domain.Cidade;
import udemy.nelio.cursojavaangular.domain.Estado;
import udemy.nelio.cursojavaangular.domain.Jogo;
import udemy.nelio.cursojavaangular.repository.CategoriaRepository;
import udemy.nelio.cursojavaangular.repository.CidadeRepository;
import udemy.nelio.cursojavaangular.repository.EstadoRepository;
import udemy.nelio.cursojavaangular.repository.JogoRepository;

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












    }
}
