package edu.comillas.icai.gitt.pat.spring.proyectofinal.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // desactiva CSRF
                .authorizeHttpRequests()
                .anyRequest().permitAll() // permite todo sin autenticación
                .and()
                .formLogin().disable(); // desactiva el formulario de login

        return http.build();
    }
}