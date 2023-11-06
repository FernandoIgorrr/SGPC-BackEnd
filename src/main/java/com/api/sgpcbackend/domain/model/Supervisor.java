package com.api.sgpcbackend.domain.model;

import com.api.sgpcbackend.domain.roles.CargoSupervisor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "supervisor")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue(value = "SUPERVISOR")
public class Supervisor extends Usuario
{
    private static final long serialVersionUID = 1L;

    @Column(name = "cargo")
    @Enumerated(EnumType.STRING)
    private CargoSupervisor cargo;
}
