//package mtech.dev.marciosales.loja_virtual_mentoria.security;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//public class JwtRequestFilter extends OncePerRequestFilter {
//
//    private final JwtUtil jwtUtil;
//    private final UserDetailsService userDetailsService;
//
//    public JwtRequestFilter(JwtUtil jwtUtil, UserDetailsService userDetailsService) {
//        this.jwtUtil = jwtUtil;
//        this.userDetailsService =userDetailsService;
//    }
//
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//    //Obtem o valor do cabeçalho "Authorization" da requisiçao
//        final String authorizationHeader = request.getHeader("Authorization");
//
//    //verifica se o cabeçalho existe e começa com "Bearer"
//        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//    //extrai o token JWT do cabeçalho
//        final String token = authorizationHeader.substring(7);
//    // extrai o nome do usuario do token JWT
//        final String username = jwtUtil.extractUsername(token);
//    // carregar o nome do usuario se nao for null ou nao tiver autenticado ainda
//        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null ) {
//    //carrega os detalhes do usuario  atraves do username
//        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//    //valida o token JWT
//        if (jwtUtil.validateToken (token,username)){
//    //cria um objeto de autenticaçao com as informaçoes do usuario
//            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//    //define a autenticaçao no contexto de segurança
//       SecurityContextHolder.getContext().setAuthentication(authentication);
//        };
//        }
//        }
//        //continua a cadeia de filter permitindo que prossiga
//        filterChain.doFilter(request,response);
//    }
//
//
//}
