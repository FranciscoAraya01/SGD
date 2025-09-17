package munipalmares.sgd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // desactiva CSRF para pruebas con Postman
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/ciudadano/**").permitAll()
                        .requestMatchers("/api/denuncia/**").permitAll()
                        .requestMatchers("/api/ticket/**").permitAll()
                        .requestMatchers("/api/estado/**").permitAll()
                        .requestMatchers("/api/verification/**").permitAll()
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}

