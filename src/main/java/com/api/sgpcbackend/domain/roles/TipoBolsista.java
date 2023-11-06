package com.api.sgpcbackend.domain.roles;

public enum TipoBolsista
{
    GERENCIA("gerencia"),
    DESIGN("design"),
    AVALICAO("avaliacao"),
    INFORMATICA("informatica");

    private String tipo;

    TipoBolsista(String tipo)
    {
        this.tipo = tipo;
    }

    public String getTipo()
    {
        return tipo;
    }
}
