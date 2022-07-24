package udemy.nelio.cursojavaangular.services;

import org.springframework.security.core.context.SecurityContextHolder;

import udemy.nelio.cursojavaangular.security.UserSS;

public class UserService {

    public static UserSS authenticated() {
        try {
            return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
        catch (Exception e) {
            return null;
        }
    }
}