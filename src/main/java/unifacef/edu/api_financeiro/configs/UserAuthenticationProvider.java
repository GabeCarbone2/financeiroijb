package unifacef.edu.api_financeiro.configs;

import unifacef.edu.api_financeiro.models.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import unifacef.edu.api_financeiro.exceptions.WrongCredentialsException;
import unifacef.edu.api_financeiro.helpers.OptionalHelper;
import unifacef.edu.api_financeiro.models.entity.Authority;
import unifacef.edu.api_financeiro.models.entity.UserInfo;
import unifacef.edu.api_financeiro.repository.UserInfoRepository;
import unifacef.edu.api_financeiro.repository.UserRepository;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserAuthenticationProvider {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        UserInfo userInfo = OptionalHelper.getOptionalEntity(userInfoRepository.findByUserEmailOrCPF(email));

        User user = userInfo.getUser();
        if(!passwordEncoder.matches(password, user.getPassword())) {
            throw new WrongCredentialsException("Wrong credentials");
        }

        return new UsernamePasswordAuthenticationToken(userInfo, password, grantedAuthorities(userInfo.getAuthority()));
    }

    public List<GrantedAuthority> grantedAuthorities(Authority authority) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(authority.getRole().toString()));

        return grantedAuthorities;
    }
}