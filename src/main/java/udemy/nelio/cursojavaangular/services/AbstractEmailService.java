package udemy.nelio.cursojavaangular.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import udemy.nelio.cursojavaangular.domain.cliente.Cliente;
import udemy.nelio.cursojavaangular.domain.pedido.Pedido;
import udemy.nelio.cursojavaangular.exception.DataIntegrityException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

public abstract class AbstractEmailService implements EmailService{
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private JavaMailSender javaMailSender;
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

    protected String htmlFromTemplatePedido(Pedido obj){
        Context context = new Context();
        context.setVariable("pedido",obj);
        return templateEngine.process("confirmacaoPedido",context);
    }
    public void sendOrderConfirmationHtmlEmail(Pedido obj){
        MimeMessage mm = null;
        try {
            mm = prepareMimemessageFromPedido(obj);
        } catch (MessagingException e) {
            sendOrderConfirmationEmail(obj);
        }
        sendHtmlEmail(mm);
    }

    protected MimeMessage prepareMimemessageFromPedido(Pedido obj) throws MessagingException {
        MimeMessage mm = javaMailSender.createMimeMessage();
        MimeMessageHelper mmHelper = new MimeMessageHelper(mm,true);
        mmHelper.setTo(obj.getCliente().getEmail());
        mmHelper.setFrom(sender);
        mmHelper.setSubject("Pedido confirmado. Codigo: "+ obj.getId());
        mmHelper.setSentDate(new Date(System.currentTimeMillis()));
        mmHelper.setText(htmlFromTemplatePedido(obj),true);
        return mm;

    }
}
