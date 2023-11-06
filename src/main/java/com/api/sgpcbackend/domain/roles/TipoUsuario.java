package com.api.sgpcbackend.domain.roles;

public enum TipoUsuario
{
    BOLSISTA("bolsista"),
    SUPERVISOR("supervisor");
    private String tipo;
    TipoUsuario(String tipo){
        this.tipo = tipo;
    }
    public String getTipo()
    {
        return tipo;
    }
}
