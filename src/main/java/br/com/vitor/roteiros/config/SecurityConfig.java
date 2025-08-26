package br.com.vitor.roteiros.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http

                .csrf(csrf -> csrf.disable())


                .cors(Customizer.withDefaults())


                .authorizeHttpRequests(authorize -> authorize

                        .requestMatchers("/api/users/**", "/api/itineraries/**").permitAll()

                        .anyRequest().authenticated()
                );
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        // Permite requisições do seu front-end React
        configuration.setAllowedOrigins(List.of("http://localhost:5173"));
        // Permite os métodos HTTP que a aplicação vai usar
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        // Permite todos os cabeçalhos nas requisições
        configuration.setAllowedHeaders(List.of("*"));
        // Permite o envio de credenciais (útil para o futuro)
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // Aplica esta configuração de CORS a todas as rotas da sua API
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}