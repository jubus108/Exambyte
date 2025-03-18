package de.hhu.propra.exambyte.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class NutzerInAppService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    @Value("${exambyte.rollen.admin}")
    private Set<String> admins;

    private final DefaultOAuth2UserService defaultService = new DefaultOAuth2UserService();

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oauth2User = defaultService.loadUser(userRequest);

        var attributes = oauth2User.getAttributes(); //keep existing attributes

        var authorities = new HashSet<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        String login = attributes.get("login").toString();
        System.out.printf("USER LOGIN: %s%n", login);

        if (admins.contains(login)) {
            System.out.printf("GRANTING ADMIN PRIVILEGES TO USER %s%n", login);
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            System.out.printf("DENYING ADMIN PRIVILEGES TO USER %s%n", login);
        }

        return new DefaultOAuth2User(authorities, attributes, "login");
    };

}

