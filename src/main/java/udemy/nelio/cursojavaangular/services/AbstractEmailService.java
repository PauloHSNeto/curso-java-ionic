package udemy.nelio.cursojavaangular.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import udemy.nelio.cursojavaangular.domain.cliente.Cliente;
import udemy.nelio.cursojavaangular.domain.pedido.Pedido;
import udemy.nelio.cursojavaangular.exception.DataIntegrityException;

import java.util.Date;

public abstract class AbstractEmailService implements EmailService{

    @Value("${default.sender}")
    private String sender;

    @Value("${default.recepient}")
    private String recepient;
    protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedido objeto){
        SimpleMailMessage smm = new SimpleMailMessage();
        smm.setTo(objeto.getCliente().getEmail());
        smm.setFrom(sender);
        smm.setSubject("Pedido Confirmado Codigo "+ objeto.getId());
        smm.setSentDate(new Date(System.currentTimeMillis()));
        smm.setText(objeto.toString());
        return smm;
}
    @Override
    public void sendOrderConfirmationEmail(Pedido obj){
        SimpleMailMessage smm = prepareSimpleMailMessageFromPedido(obj);
        sendEmail(smm);
    }

    protected SimpleMailMessage prepareNewPasswordEmail(Cliente cliente, String newPass) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(cliente.getEmail());
        sm.setFrom(sender);
        sm.setSubject("Solicitação de nova senha");
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText("Nova senha: " + newPass);
        return sm;
    }


    @Override
    public void sendNewPasswordEmail(Cliente cliente, String newPass) {
        SimpleMailMessage sm = prepareNewPasswordEmail(cliente, newPass);
        sendEmail(sm);
    }
}
