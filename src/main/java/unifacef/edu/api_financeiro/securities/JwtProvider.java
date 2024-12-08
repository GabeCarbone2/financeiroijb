package unifacef.edu.api_financeiro.securities;

import unifacef.edu.api_financeiro.models.enums.Role;
import unifacef.edu.api_financeiro.configs.UserAuthenticationProvider;
import unifacef.edu.api_financeiro.exceptions.InvalidJwtTokenException;
import unifacef.edu.api_financeiro.helpers.OptionalHelper;
import unifacef.edu.api_financeiro.helpers.SecretKeyHelper;
import unifacef.edu.api_financeiro.models.entity.Authority;
import unifacef.edu.api_financeiro.models.entity.User;
import unifacef.edu.api_financeiro.models.entity.UserInfo;
import unifacef.edu.api_financeiro.repository.UserInfoRepository;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Component
public class JwtProvider {
    @Autowired
    private SecretKeyHelper secretKeyHelper;
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private UserAuthenticationProvider userAuthenticationProvider;

    public String createToken(Authentication authentication) {
        Date date = new Date();
        SecretKey key = secretKeyHelper.secretKeyBuilder();

        return Jwts.builder()
                .issuer("IJB API")
                .claims(claimsSetup(authentication))
                .subject("JWT Token")
                .issuedAt(date)
                .expiration(new Date(date.getTime() + 3600000L))
                .signWith(key)
                .compact();
    }

    private Map<String, String> claimsSetup(Authentication authentication) {
        UserInfo userInfo = (UserInfo) authentication.getPrincipal();
        User user = userInfo.getUser();
        Authority authority = userInfo.getAuthority();
        Role role = authority.getRole();

        Map<String, String> claims = new HashMap<>();

        claims.put("email", user.getEmail());
        claims.put("role", role.getType());

        return claims;
    }

    public boolean validateToken(String token) {
        SecretKey secretKey = secretKeyHelper.secretKeyBuilder();

        try {
            Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token);
            return true;
        } catch (JwtException | IllegalStateException e) {
            throw new InvalidJwtTokenException(e.getMessage());
        }
    }

    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");

        if(bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }

        return null;
    }

    public Authentication getAuthentication(String token) {
        UserInfo userInfo = OptionalHelper.getOptionalEntity(userInfoRepository.findByUserEmail
                (getUserEmailFromToken(token)));

        return new UsernamePasswordAuthenticationToken(userInfo, "",
                userAuthenticationProvider.grantedAuthorities(userInfo.getAuthority()));
    }

    private String getUserEmailFromToken(String token) {
        SecretKey secretKey = secretKeyHelper.secretKeyBuilder();

        return Jwts.parser().verifyWith(secretKey).build()
                .parseSignedClaims(token).getPayload().get("email", String.class);
    }
}