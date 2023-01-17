package com.example.springsecurity.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class BasicAuthSecurityConfiguration {

    @Bean
    SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> {
            auth.anyRequest().authenticated();
        });
        http.sessionManagement(session -> {
            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        });
        http.httpBasic();
        http.csrf().disable();
        http.headers().frameOptions().sameOrigin(); // allows frames from same origin
        return http.build();
    }

    // in memory user details login/pw
    @Bean
    public UserDetailsService userDetailsService(){

        var user = User.withUsername("user")
                .password("{noop}user")
                .roles("USER")
                .build();

        var admin = User.withUsername("admin")
                .password("{noop}user")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder()
    }
}
