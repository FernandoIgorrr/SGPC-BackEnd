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
                        requestMatchers(HttpMethod.GET,"/api/patrimonio/listar_por_complexo").hasRole("USER").
                        requestMatchers(HttpMethod.GET,"/api/patrimonio/listar_por_predio").hasRole("USER").
                        requestMatchers(HttpMethod.GET,"/api/patrimonio/listar_por_andar").hasRole("USER").
                        requestMatchers(HttpMethod.GET,"/api/patrimonio/listar_por_comodo").hasRole("USER").
                        requestMatchers(HttpMethod.GET,"/api/patrimonio/estado/listar").hasRole("USER").
                        requestMatchers(HttpMethod.GET,"/api/patrimonio/tipo/listar").hasRole("USER").

                        requestMatchers(HttpMethod.GET,"/api/localidade/complexo/listar").hasRole("USER").
                        requestMatchers(HttpMethod.GET,"/api/localidade/predio/listar").hasRole("USER").
                        requestMatchers(HttpMethod.GET,"/api/localidade/andar/listar").hasRole("USER").
                        requestMatchers(HttpMethod.GET,"/api/localidade/comodo/listar").hasRole("USER").

                        requestMatchers(HttpMethod.GET,"/api/pc_specs/modelo/listar").hasRole("USER").
                        requestMatchers(HttpMethod.GET,"/api/pc_specs/sistema_operacional/listar").hasRole("USER").
                        requestMatchers(HttpMethod.GET,"/api/pc_specs/ram/listar").hasRole("USER").
                        requestMatchers(HttpMethod.GET,"/api/pc_specs/ram_ddr/listar").hasRole("USER").
                        requestMatchers(HttpMethod.GET,"/api/pc_specs/hd/listar").hasRole("USER").


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
