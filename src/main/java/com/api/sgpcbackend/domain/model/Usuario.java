package com.api.sgpcbackend.domain.model;

import com.api.sgpcbackend.domain.dto.BolsistaCadastroDTO;
import com.api.sgpcbackend.domain.roles.TipoBolsista;
import com.api.sgpcbackend.domain.roles.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@EqualsAndHashCode(of = {"id"})
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_usuario",discriminatorType = DiscriminatorType.INTEGER)
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable, UserDetails
{
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "login", length = 25, unique = true)
    @NotNull(message = "É necessário preencher o campo login")
    protected String login;

    //@Size(min = 8, message = "A senha deve ter no mínimo 8 caracters")
    @Column(name = "senha", length = 80)
    //@NotNull(message = "É necessário preencher o campo senha")
    protected String senha;

    @Column(name = "nome", length = 100)
    @NotNull(message = "É necessário preencher o nome do usuário")
    protected String nome;

    @Column(name = "email", length = 50, unique = true)
    @NotNull(message = "É necessário preencher o E-mail do usuário")
    protected String email;

    @Column(name = "telefone", length = 12)
    protected String telefone;

    @Column(name = "ativo")
    protected Boolean atvio;

    @ManyToOne
    @JoinColumn(name = "tipo_usuario",insertable = false,updatable = false)
   // @NotNull(message = "O tipo de usuário deve ser escolhido")
    protected TipoUsuario tipo_usuario;

    @Column(name = "data_chegada")
    @NotNull(message = "A data de início das atividades do usuário deve ser inserida")
    @JsonFormat(pattern = "dd-MM-yyyy")
    protected LocalDate data_chegada;

    @Column(name = "data_saida")
    @JsonFormat(pattern = "dd-MM-yyyy")
    protected LocalDate data_saida;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        if(tipo_usuario.getId() == 1)
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));

        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public void alterarSenha(String novaSenha)
    {
        senha = novaSenha;
    }

    @Override
    public String getPassword()
    {
        return getSenha();
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
