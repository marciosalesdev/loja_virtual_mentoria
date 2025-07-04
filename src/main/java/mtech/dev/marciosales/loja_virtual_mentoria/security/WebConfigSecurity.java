package mtech.dev.marciosales.loja_virtual_mentoria.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true) // substitui o antigo EnableGlobalMethodSecurity
public class WebConfigSecurity {


//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers(HttpMethod.GET, "/salvar-access").permitAll()
//                        .requestMatchers(HttpMethod.POST, "/salvar-access").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());
//
//
//        return http.build();
//    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desabilita CSRF para testes com Postman
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Permite tudo (teste somente!)
                );

        return http.build();
    }
}