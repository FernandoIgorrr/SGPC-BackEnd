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
                        requestMatchers(HttpMethod.POST,"/api/usuario/usuario_dados").hasRole("USER").
                        requestMatchers(HttpMethod.PUT,"/api/usuario/alterar_senha").hasRole("USER").


                        requestMatchers(HttpMethod.POST,"/api/bolsista/cadastrar").hasRole("ADMIN").
                        requestMatchers(HttpMethod.GET,"/api/bolsista/listar").hasRole("ADMIN").
                        requestMatchers(HttpMethod.GET,"/api/bolsista/tipo/listar").hasRole("USER").
                        requestMatchers(HttpMethod.PUT,"/api/bolsista/bolsista/atualizar").hasRole("ADMIN").

                        requestMatchers(HttpMethod.POST,"/api/supervisor/cadastrar").hasRole("ADMIN").
                        requestMatchers(HttpMethod.POST,"/api/supervisor/listar").hasRole("ADMIN").

                        requestMatchers(HttpMethod.GET,"/api/usuario/listar").hasRole("ADMIN").

                        requestMatchers(HttpMethod.POST,"/api/patrimonio/cadastrar").hasRole("USER").
                        requestMatchers(HttpMethod.POST,"/api/patrimonio/atualizar").hasRole("USER").
                        requestMatchers(HttpMethod.PUT,"/api/patrimonio/alienar").hasRole("USER").
                        requestMatchers(HttpMethod.PUT,"/api/patrimonio/alienar/listar").hasRole("USER").
                        requestMatchers(HttpMethod.POST,"/api/patrimonio/computador/cadastrar").hasRole("USER").
                        requestMatchers(HttpMethod.PUT,"/api/patrimonio/computador/atualizar").hasRole("USER").
                        requestMatchers(HttpMethod.PUT,"/api/patrimonio/manejar").hasRole("USER").
                        requestMatchers(HttpMethod.GET,"/api/patrimonio/get_patrimonio").hasRole("USER").

                        requestMatchers(HttpMethod.POST,"/api/patrimonio/computador/cadastrar_lista").hasRole("USER").


                        requestMatchers(HttpMethod.GET,"/api/patrimonio/listar").hasRole("USER").
                        requestMatchers(HttpMethod.GET,"/api/patrimonio/listarr").hasRole("USER").
                        requestMatchers(HttpMethod.GET,"/api/patrimonio/listar_por_complexo").hasRole("USER").
                        requestMatchers(HttpMethod.GET,"/api/patrimonio/listar_por_predio").hasRole("USER").
                        requestMatchers(HttpMethod.GET,"/api/patrimonio/listar_por_andar").hasRole("USER").
                        requestMatchers(HttpMethod.GET,"/api/patrimonio/listar_por_comodo").hasRole("USER").
                        requestMatchers(HttpMethod.GET,"/api/patrimonio/listar_por_tipo").hasRole("USER").
                        requestMatchers(HttpMethod.GET,"/api/patrimonio/computador/listar_por_complexo").hasRole("USER").
                        requestMatchers(HttpMethod.GET,"/api/patrimonio/computador/listar_por_predio").hasRole("USER").
                        requestMatchers(HttpMethod.GET,"/api/patrimonio/computador/listar_por_andar").hasRole("USER").
                        requestMatchers(HttpMethod.GET,"/api/patrimonio/estado/listar").hasRole("USER").
                        requestMatchers(HttpMethod.GET,"/api/patrimonio/tipo/listar").hasRole("USER").

                        requestMatchers(HttpMethod.GET,"/api/manejo/listar").hasRole("USER").

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

                        requestMatchers(HttpMethod.POST,"/api/chamado/cadastrar").hasRole("USER").
                        requestMatchers(HttpMethod.PUT,"/api/chamado/fechar").hasRole("USER").
                        requestMatchers(HttpMethod.PUT,"/api/chamado/alterar").hasRole("USER").
                        requestMatchers(HttpMethod.GET,"/api/chamado/listar").hasRole("USER").
                        requestMatchers(HttpMethod.GET,"/api/chamado/listar_por_estado").hasRole("USER").
                        requestMatchers(HttpMethod.GET,"/api/chamado/estado/listar").hasRole("USER").
                        requestMatchers(HttpMethod.GET,"/api/chamado/tipo/listar").hasRole("USER").


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
