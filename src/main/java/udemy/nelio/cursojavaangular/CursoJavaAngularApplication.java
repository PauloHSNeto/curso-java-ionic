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
import udemy.nelio.cursojavaangular.services.S3Service;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class CursoJavaAngularApplication implements CommandLineRunner {
    @Autowired
    private S3Service s3Service;


    public static void main(String[] args) {
        SpringApplication.run(CursoJavaAngularApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        s3Service.uploadFile("C:\\Users\\015070631\\Downloads\\avatar.jpg");

    }
}
