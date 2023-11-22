package com.api.sgpcbackend.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations
{
    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
    {
        return httpSecurity.
                csrf(AbstractHttpConfigurer::disable).
                sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).
                authorizeHttpRequests(authorize -> authorize.
                        requestMatchers(HttpMethod.POST,"/api/auth/login").permitAll().
                        requestMatchers(HttpMethod.GET,"/api/patrimonio/exemplo").permitAll().


                        requestMatchers(HttpMethod.POST,"/api/bolsista/cadastrar").hasRole("ADMIN").
                        //requestMatchers(HttpMethod.POST,"/api/bolsista/cadastrar").permitAll().
                        requestMatchers(HttpMethod.GET,"/api/bolsista/listar").hasRole("ADMIN").
                        //requestMatchers(HttpMethod.POST,"/api/bolsista/listar").permitAll().


                        //requestMatchers(HttpMethod.POST,"/api/supervisor/cadastrar").hasRole("ADMIN").
                        requestMatchers(HttpMethod.POST,"/api/supervisor/cadastrar").permitAll().
                        requestMatchers(HttpMethod.POST,"/api/supervisor/listar").hasRole("ADMIN").
                        //requestMatchers(HttpMethod.POST,"/api/supervisor/listar").permitAll().


                        requestMatchers(HttpMethod.GET,"/api/usuario/listar").hasRole("ADMIN").
                        //requestMatchers(HttpMethod.GET,"/api/usuario/listar").permitAll().


                        requestMatchers(HttpMethod.POST,"/api/patrimonio/cadastrar").hasRole("USER").
                        requestMatchers(HttpMethod.POST,"/api/patrimonio/atualizar").hasRole("USER").
                        requestMatchers(HttpMethod.POST,"/api/patrimonio/computador/cadastrar").hasRole("USER").

                        requestMatchers(HttpMethod.POST,"/api/patrimonio/computador/cadastrar_lista").hasRole("USER").


                        requestMatchers(HttpMethod.GET,"/api/patrimonio/listar").hasRole("USER").
                        requestMatchers(HttpMethod.POST,"/api/patrimonio/estados_patrimonio").hasRole("USER").
                        requestMatchers(HttpMethod.POST,"/api/patrimonio/tipos_patrimonio").hasRole("USER").
                        requestMatchers(HttpMethod.GET,"/api/patrimonio/computador/listar").hasRole("USER").


                        anyRequest().authenticated()).
                addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class).
                build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception
    {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
