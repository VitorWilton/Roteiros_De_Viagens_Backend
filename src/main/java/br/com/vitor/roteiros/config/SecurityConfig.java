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

    /**
     * Este método configura as regras de segurança HTTP (quem pode acessar o quê).
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. Desabilita o CSRF (o que corrige o erro 403 no POST)
                .csrf(csrf -> csrf.disable())

                // 2. Habilita o CORS (usa a configuração definida no método abaixo)
                .cors(Customizer.withDefaults())

                // 3. Define as regras de autorização para cada endpoint
                .authorizeHttpRequests(authorize -> authorize
                        // Permite acesso PÚBLICO a todos os endpoints de users e itineraries
                        .requestMatchers("/api/users/**", "/api/itineraries/**").permitAll()
                        // Exige que qualquer outra requisição seja autenticada
                        .anyRequest().authenticated()
                );
        return http.build();
    }

    /**
     * Este método define as regras de CORS, dizendo ao navegador
     * que é seguro para o front-end acessar o back-end.
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        // Permite requisições do seu front-end React
        configuration.setAllowedOrigins(List.of("http://localhost:5173"));
        // Permite os métodos HTTP que sua aplicação vai usar
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