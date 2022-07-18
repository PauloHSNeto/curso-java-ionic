package udemy.nelio.cursojavaangular.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import udemy.nelio.cursojavaangular.services.DBService;
import udemy.nelio.cursojavaangular.services.EmailService;
import udemy.nelio.cursojavaangular.services.MockEmailService;
import udemy.nelio.cursojavaangular.services.SMTPEMailService;

import java.text.ParseException;

@Configuration
@Profile("dev")
public class DevConfig {
    @Autowired
    private DBService dbService;
    @Value("$spring.jpa.hibernate.ddl-auto")
    private String strategy;

    @Bean
    public boolean instantiateDatabase() throws ParseException {
        dbService.instantiateTestDatabase();
        return true;
    }

    @Bean
    public EmailService emailService(){
        return new SMTPEMailService();
    }
}
