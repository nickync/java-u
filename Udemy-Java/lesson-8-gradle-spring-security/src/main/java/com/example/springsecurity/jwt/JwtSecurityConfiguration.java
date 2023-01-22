package com.example.springsecurity.jwt;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

@Configuration
public class JwtSecurityConfiguration {

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

        http.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);

        return http.build();
    }

    // in memory user details login/pw
//    @Bean
//    public UserDetailsService userDetailsService(){
//
//        var user = User.withUsername("user")
//                .password("{noop}user")
//                .roles("USER")
//                .build();
//
//        var admin = User.withUsername("admin")
//                .password("{noop}user")
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }

    @Bean
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource){

        var user = User.withUsername("user")
//                .password("{noop}user")
                .password("user")
                .passwordEncoder(str -> passwordEncoder().encode(str))
                .roles("USER")
                .build();

        var admin = User.withUsername("admin")
//                .password("{noop}user")
                .password("user")
                .passwordEncoder(str -> passwordEncoder().encode(str))
                .roles("ADMIN")
                .build();

        var jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.createUser(user);
        jdbcUserDetailsManager.createUser(admin);

        return jdbcUserDetailsManager;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public JwtDecoder decoder(){
//        need to set up a jwt decoder for oauth2resource
//          1. Create Key Pair
//              use java.security.KeyPairGenerator OR openssl
//          2. Create RSA Key object using Pair
//              com.nimbusds.jose.jwk.RSAKey
//          3. Create JWKSource (JSON Web Key source)
//              create JWKSet (a new JSON Web Key set) with the RSA Key
//              create JWKSource using the JWKSet
//          4. Use RSA Public Key for Decoding
//              NimbusJwtDecoder.withPublicKey(rsaKey().toRSAPublicKey()).build()
//          5. Use JWKSource for Encoding
//              return new NimbusJWtEncoder(jwkSource());
//    }



    @Bean
    public KeyPair keyPair() {
        //    1. Create Key Pair
        try {
            var keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            return keyPairGenerator.generateKeyPair();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Bean
    public RSAKey rsaKey(KeyPair keyPair) {
        // 2.Create RSA Key object
        return new RSAKey.Builder((RSAPublicKey) keyPair.getPublic())
                .privateKey(keyPair.getPrivate())
                .keyID(UUID.randomUUID().toString())
                .build();
    }

//    @Bean
//    public JWKSource jwkSource(RSAKey rsaKey) {
//          3. Create JWKSource (JSON Web Key source)
//              create JWKSet (a new JSON Web Key set) with the RSA Key
//              create JWKSource using the JWKSet
//        var jwkSet = new JWKSet(rsaKey);
//        var jwkSource = new JWKSource() {
//            @Override
//            public List get(JWKSelector jwkSelector, SecurityContext context) {
//                return jwkSelector.select(jwkSet);
//            }
//        };
//
//        return jwkSource;
//        // lambda way of implementing this method below
//    }

    @Bean
    public JWKSource<SecurityContext> jwkSource(RSAKey rsaKey) {
//          3. Create JWKSource (JSON Web Key source)
//              create JWKSet (a new JSON Web Key set) with the RSA Key
//              create JWKSource using the JWKSet
        var jwkSet = new JWKSet(rsaKey);
        return ((jwkSelector, context) -> jwkSelector.select(jwkSet));
    }

    @Bean
    public JwtDecoder jwtDecoder(RSAKey rsaKey) throws JOSEException {
        return NimbusJwtDecoder
                .withPublicKey(rsaKey.toRSAPublicKey())
                .build();
    }

    @Bean
    public JwtEncoder jwtEncoder(JWKSource<SecurityContext> jwkSource){
        return new NimbusJwtEncoder(jwkSource);
    }

}
