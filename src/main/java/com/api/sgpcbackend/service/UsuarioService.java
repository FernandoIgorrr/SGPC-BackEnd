package com.api.sgpcbackend.service;

import org.apache.commons.lang3.RandomStringUtils;

import java.nio.charset.Charset;
import java.util.Random;

public class UsuarioService {

    public static String gerarSenhaTemporaria()
    {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
        String pwd = RandomStringUtils.random( 12, characters );
        return pwd;
    }
}
