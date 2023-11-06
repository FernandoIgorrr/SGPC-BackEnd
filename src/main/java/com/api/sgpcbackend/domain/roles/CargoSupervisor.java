package com.api.sgpcbackend.domain.roles;

public enum CargoSupervisor
{
    CHEFE("chefe"),
    OPERADOR("operador"),
    ADMINISTRADOR("administrador");

    private String cargo;

    CargoSupervisor(String cargo)
    {
        this.cargo = cargo;
    }

    public String getCargo()
    {
        return cargo;
    }
}
