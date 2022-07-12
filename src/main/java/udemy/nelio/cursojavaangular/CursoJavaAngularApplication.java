package udemy.nelio.cursojavaangular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import udemy.nelio.cursojavaangular.domain.Categoria;
import udemy.nelio.cursojavaangular.domain.Jogo;
import udemy.nelio.cursojavaangular.repository.CategoriaRepository;
import udemy.nelio.cursojavaangular.repository.JogoRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CursoJavaAngularApplication implements CommandLineRunner {
    @Autowired
    private CategoriaRepository repo;
    @Autowired
    private JogoRepository jogoRepo;

    public static void main(String[] args) {
        SpringApplication.run(CursoJavaAngularApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria(null, "RPG");
        Categoria cat2 = new Categoria(null, "Strategy");
        Categoria cat3 = new Categoria(null, "Adventure");
        repo.saveAll(Arrays.asList(cat1,cat2,cat3));


        Jogo jogo1 = new Jogo(null,"Skyrim",60.00);
        Jogo jogo2 = new Jogo(null, "Starcraft", 50.00);
        Jogo jogo3 = new Jogo(null, "Mass Effect", 70.00);

        cat1.getJogos().addAll(Arrays.asList(jogo1,jogo3));
        cat2.getJogos().addAll(Arrays.asList(jogo2));
        jogo1.getCategorias().add(cat1);
        jogo2.getCategorias().add(cat2);
        jogo3.getCategorias().addAll(Arrays.asList(cat1,cat3));

        jogoRepo.saveAll(Arrays.asList(jogo1,jogo2,jogo3));

    }
}
