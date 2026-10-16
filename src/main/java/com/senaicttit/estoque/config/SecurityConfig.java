package com.senaicttit.estoque.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
// Instanciando o Sprint Security
public class SecurityConfig {
    @Bean
    /* Usando o engriptador de senhas do proprio Spring */
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
