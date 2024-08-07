package com.curso.springboot.error.springboot_error;


import com.curso.springboot.error.springboot_error.models.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    List<User> users() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Alex", "Zea"));
        users.add(new User(2L, "Andres", "Nuñez"));
        users.add(new User(3L, "Amed", "Quiroz"));
        users.add(new User(4L, "Jose", "Zegarra"));
        users.add(new User(5L, "Juan", "Ramos"));
        return users;
    }


}
