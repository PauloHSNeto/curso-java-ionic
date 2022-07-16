package udemy.nelio.cursojavaangular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import udemy.nelio.cursojavaangular.domain.cliente.Cidade;
import udemy.nelio.cursojavaangular.domain.cliente.Cliente;
import udemy.nelio.cursojavaangular.domain.cliente.Endereco;
import udemy.nelio.cursojavaangular.domain.cliente.Estado;
import udemy.nelio.cursojavaangular.domain.pedido.*;
import udemy.nelio.cursojavaangular.domain.produto.Categoria;
import udemy.nelio.cursojavaangular.domain.produto.Jogo;
import udemy.nelio.cursojavaangular.enums.EstadoPagamento;
import udemy.nelio.cursojavaangular.enums.TipoCliente;
import udemy.nelio.cursojavaangular.repository.*;

import java.text.SimpleDateFormat;
import java.util.Arrays;

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

    @Autowired
    private PedidoRepository pedRepo;

    @Autowired
    private PagamentoRepository pgtoRepo;

    @Autowired
    private ItemPedidoRepository ipRepo;



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
        Jogo jogo1 = new Jogo(null,"Skyrim",60.00);
        Jogo jogo2 = new Jogo(null, "Starcraft", 50.00);
        Jogo jogo3 = new Jogo(null, "Mass Effect", 70.00);
        Jogo jogo4 = new Jogo(null,"Fire Emblem",60.00);
        Jogo jogo5 = new Jogo(null, "Zelda", 50.00);
        Jogo jogo6 = new Jogo(null, "X-COM", 70.00);
        Jogo jogo7 = new Jogo(null,"Splatoon",60.00);
        Jogo jogo8 = new Jogo(null, "Left 4 Dead", 50.00);
        Jogo jogo9 = new Jogo(null, "Silent Hill", 70.00);
        Jogo jogo10 = new Jogo(null,"Candy Crush",60.00);
        Jogo jogo11= new Jogo(null, "DOOM", 50.00);
        Jogo jogo12 = new Jogo(null, "World of Warcraft", 70.00);

        cat1.getJogos().addAll(Arrays.asList(jogo1,jogo3,jogo4,jogo12));
        cat2.getJogos().addAll(Arrays.asList(jogo2,jogo4,jogo6));
        cat3.getJogos().addAll(Arrays.asList(jogo1,jogo5));
        cat4.getJogos().addAll(Arrays.asList(jogo3,jogo6,jogo7,jogo8,jogo11));
        cat5.getJogos().addAll(Arrays.asList(jogo2,jogo7,jogo8,jogo12));
        cat6.getJogos().addAll(Arrays.asList(jogo8,jogo9));
        cat7.getJogos().addAll(Arrays.asList(jogo11));
        jogo1.getCategorias().addAll(Arrays.asList(cat1,cat3));
        jogo2.getCategorias().addAll(Arrays.asList(cat2,cat5));
        jogo3.getCategorias().addAll(Arrays.asList(cat1,cat4));
        jogo4.getCategorias().addAll(Arrays.asList(cat1,cat2));
        jogo5.getCategorias().addAll(Arrays.asList(cat3));
        jogo6.getCategorias().addAll(Arrays.asList(cat2,cat4));
        jogo7.getCategorias().addAll(Arrays.asList(cat4,cat5));
        jogo8.getCategorias().addAll(Arrays.asList(cat4,cat5,cat6));
        jogo9.getCategorias().addAll(Arrays.asList(cat1,cat3));
        jogo10.getCategorias().addAll(Arrays.asList(cat6));
        jogo11.getCategorias().addAll(Arrays.asList(cat7));
        jogo12.getCategorias().addAll(Arrays.asList(cat1,cat5));

        catrepo.saveAll(Arrays.asList(cat1,cat2,cat3,cat4,cat5,cat6,cat7));
        jogoRepo.saveAll(Arrays.asList(jogo1,jogo2,jogo3,jogo4,jogo5,jogo6,jogo7,jogo8,jogo9,jogo10,jogo11,jogo12));

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

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Pedido ped1 = new Pedido(null, sdf.parse("21/03/1989 11:22"),cli1,end2);
        Pedido ped2 = new Pedido(null,sdf.parse("13/07/2022 11:24"), cli1,end1);

        Pagamento pgto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO,ped1,4);
        ped1.setPagamento(pgto1);

        Pagamento pgto2 = new PagamentoComBoleto(null,EstadoPagamento.PENDENTE,ped2,sdf.parse("20/10/2023 00:00"),null);
        ped2.setPagamento(pgto2);

        cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));

        pedRepo.saveAll(Arrays.asList(ped1,ped2));
        pgtoRepo.saveAll(Arrays.asList(pgto1,pgto2));

        ItemPedido ip1 = new ItemPedido(ped1,jogo1,0.00,1,60.00);
        ItemPedido ip2 = new ItemPedido(ped1,jogo3,0.00,2,70.00);
        ItemPedido ip3 = new ItemPedido(ped2,jogo2,100.00,3,50.00);

        ped1.getItems().addAll(Arrays.asList(ip1,ip2));
        ped2.getItems().addAll(Arrays.asList(ip3));

        jogo1.getItems().addAll(Arrays.asList(ip1));
        jogo2.getItems().addAll(Arrays.asList(ip3));
        jogo3.getItems().addAll(Arrays.asList(ip2));

        ipRepo.saveAll(Arrays.asList(ip1,ip2,ip3));

    }
}
