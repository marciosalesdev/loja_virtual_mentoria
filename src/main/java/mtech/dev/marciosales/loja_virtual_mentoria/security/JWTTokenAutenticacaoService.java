package mtech.dev.marciosales.loja_virtual_mentoria.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.ArrayList;
import java.util.Date;

@Service
public class JWTTokenAutenticacaoService {

    private static final String HEADER = "Authorization";
    private static final String PREFIX = "Bearer ";

    private final SecretKey secretKey = Keys.hmacShaKeyFor(
            "minha-chave-super-secreta-minha-chave-super-secreta".getBytes()
    );

    public void addAuthentication(HttpServletResponse response, String username) {

        String token = Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 86400000)) // 1 dia
                .signWith(secretKey)
                .compact();

        response.addHeader(HEADER, PREFIX + token);
    }

    public Authentication getAuthentication(HttpServletRequest request) {

        String token = request.getHeader(HEADER);

        if (token != null && token.startsWith(PREFIX)) {

            String tokenLimpo = token.replace(PREFIX, "");

            Claims claims = Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(tokenLimpo)
                    .getPayload();

            String user = claims.getSubject();

            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }
        }

        return null;
    }
}