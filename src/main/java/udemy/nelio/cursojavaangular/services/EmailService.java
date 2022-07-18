package udemy.nelio.cursojavaangular.services;

import org.springframework.mail.SimpleMailMessage;
import udemy.nelio.cursojavaangular.domain.cliente.Cliente;
import udemy.nelio.cursojavaangular.domain.pedido.Pedido;

public interface EmailService {

    void sendOrderConfirmationEmail(Pedido obj);

    void sendEmail(SimpleMailMessage msg);

    void sendNewPasswordEmail(Cliente cliente, String newPass);
}
