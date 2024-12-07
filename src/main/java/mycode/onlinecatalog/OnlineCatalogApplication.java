package mycode.onlinecatalog;

import mycode.onlinecatalog.app.users.model.User;
import mycode.onlinecatalog.app.users.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class OnlineCatalogApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineCatalogApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {

        return args -> {

        };
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return  new BCryptPasswordEncoder();
    }
}
