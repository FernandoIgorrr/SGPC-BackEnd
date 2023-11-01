//package com.api.sgpcbackend.model;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
//import lombok.*;
//
//@Data
//@Table(name = "bolsista")
//@Getter
//@Entity
//@EqualsAndHashCode(callSuper = false)
//@NoArgsConstructor
//@AllArgsConstructor
//public class BolsistaModel extends UsuarioModel{
//
//    private static final long serialVersionUID = 1L;
//
//    @NotNull(message = "A matricula do bolsista deve ser preenchida")
//    @Column(name = "matricula", unique = true)
//    private String matricula;
//
//    @NotNull(message = "O tipo do bolsista deve ser escolhido")
//    @Column(name = "tipo_bolsista", table = "bolsista")
//    private Integer tipo_bolsista;
//
//}
