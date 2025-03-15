package de.hhu.propra.exambyte.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity chainBuilder) throws Exception {
        chainBuilder.authorizeHttpRequests(
                        // Haupt- und Loginseiten sollen öffentlich zugänglich sein, alles andere nur mit Authentifizierung
                        configurer -> configurer.requestMatchers("/", "/login").permitAll()
                                .anyRequest().authenticated()
                )
                .oauth2Login(config ->
                        config.userInfoEndpoint(
                                info -> info.userService(new AppUserService())
                        ));
        return chainBuilder.build();
    }
}
