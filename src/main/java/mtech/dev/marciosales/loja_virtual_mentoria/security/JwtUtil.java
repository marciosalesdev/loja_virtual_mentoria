//package mtech.dev.marciosales.loja_virtual_mentoria.security;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.stereotype.Service;
//
//import javax.crypto.SecretKey;
//import java.util.Date;
//
//@Service
//public class JwtUtil {
//    //chave secreta usada para assinar  e verificar tokens jwt
//    private final SecretKey secretKey;
//    //
//    public JwtUtil() {
//        //gera uma chave secreta com algoritmo de assinatura
//        this.secretKey = Keys.secretKeyFor(SignatureAlgorithm.ES256);
//    }
//
//    public String generateToken(String username) {
//        return Jwts.builder()
//                .setSubject(username)//define o nome do usuario como assunto do token
//                .setIssuedAt(new Date())//define a data e hora da emissao
//                .setExpiration(new Date(System.currentTimeMillis() * 1000 * 60 * 60))//define a hora para expirar
//                .signWith(secretKey) //assina o token com a have secreta
//                .compact(); //controi o token
//
//    }
//    //extrai as clains do token JWT
//    public Claims extractClains(String token) {
//        return Jwts.parser()
//                .setSigningKey(secretKey)//define a achave e valida a assinatura
//                .build()
//                .parseClaimsJws(token)//analisa o token e obtem os clans
//                .getBody();
//    }
//    public String extractUsername(String token) {
//        //extrai o nome do usuario do token
//        return extractClains(token).getSubject();
//    }
//
//    public boolean isTokenExpired(String token) {
//        //compara a data de expiraçao com a data atual
//    return extractClains(token).getExpiration().before(new Date());
//    }
//
//    public boolean validateToken(String token, String username) {
////extrai o nome do usuario do token
//        final String extractedUsername = extractUsername(token);
//        //verifica se o nome do usuarioname corresponde ao usuario token
//        return extractedUsername.equals(username) && isTokenExpired(token);
//
//
//    }
//}
