package de.hhu.propra.exambyte.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class WebSecurityConfig{

    @Bean
    public SecurityFilterChain configure(HttpSecurity chainBuilder) throws Exception {
        chainBuilder.authorizeHttpRequests(
                        configurer -> configurer
                                .requestMatchers("/", "/login", "/error", "/css/*", "/img/**").permitAll()
                                .anyRequest().authenticated()
                )
                .logout(l -> l.logoutSuccessUrl("/").permitAll())
                .oauth2Login(Customizer.withDefaults());
        return chainBuilder.build();
    }
}
