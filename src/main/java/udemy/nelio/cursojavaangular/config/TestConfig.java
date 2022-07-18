package udemy.nelio.cursojavaangular.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import udemy.nelio.cursojavaangular.services.DBService;
import udemy.nelio.cursojavaangular.services.EmailService;
import udemy.nelio.cursojavaangular.services.MockEmailService;

import javax.validation.constraints.Email;
import java.text.ParseException;

@Configuration
@Profile("test")
public class TestConfig {
    @Autowired
    private DBService dbService;
    @Bean
    public boolean instantiateDatabase() throws ParseException {
        dbService.instantiateTestDatabase();
        return true;
    }
    @Bean
    public EmailService emailService(){
        return new MockEmailService();
    }
}
