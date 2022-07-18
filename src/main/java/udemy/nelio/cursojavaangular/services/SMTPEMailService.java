package udemy.nelio.cursojavaangular.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.internet.MimeMessage;

public class SMTPEMailService extends AbstractEmailService{
    private static final Logger LOG = LoggerFactory.getLogger(SMTPEMailService.class);
        @Autowired
        private JavaMailSender javaMailSender;
        @Autowired
    private MailSender mailSender;
    @Override
    public void sendEmail(SimpleMailMessage msg) {

        LOG.info("Simulando envio de email...");
        mailSender.send(msg);
        LOG.info("Email enviado");
    }

    @Override
    public void sendHtmlEmail(MimeMessage msg) {
        LOG.info("Simulando envio de email...");
        javaMailSender.send(msg);
        LOG.info("Email enviado");
    }
}
