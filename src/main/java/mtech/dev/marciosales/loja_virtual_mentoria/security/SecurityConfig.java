//package mtech.dev.marciosales.loja_virtual_mentoria.security;
//
//import com.fasterxml.jackson.core.PrettyPrinter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private final JwtUtil jwtUtil;
//    private final  UserDetailsService userDetailsService;
//
//    public SecurityConfig(JwtUtil jwtUtil, UserDetailsService userDetailsService) {
//        this.jwtUtil = jwtUtil;
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//       // cria uma instancia do JwtRequestFilter e userDateils
//        JwtRequestFilter jwtRequestFilter = new JwtRequestFilter(jwtUtil, userDetailsService);
//
//        http
//        .csrf(csrf -> csrf.disable()) // Desabilita CSRF para testes com Postman
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/usuario/login").permitAll()//permite acessa tela de login
//                        .requestMatchers(HttpMethod.POST, "/usuario").permitAll()//nao precisa de autenticaçao para criar usuario
//                        .requestMatchers("/usuario/**").authenticated()//requer autenticaçao
//                        .anyRequest().authenticated()//requer autenticaçao para todas as outras requisiçoes
//                )
//                .sessionManagement(sessionManagement -> sessionManagement
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)//configura a politica da seçao
//                ).addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class); //adicionar o filtro JWT antes do filtro de autenticaçao
//
//        //retorna a configuraçao do filtro
//        return http.build();
//    }
//
//    //confirgura o encoderCriptografar
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();//retorna uma instancia de passwordEncoder
//    }
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration ) throws Exception {
//        //retorna a configuraçao do autenticador
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//
//}
