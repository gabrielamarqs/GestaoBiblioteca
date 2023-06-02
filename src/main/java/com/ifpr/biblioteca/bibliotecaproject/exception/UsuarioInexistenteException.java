package com.ifpr.biblioteca.bibliotecaproject.exception;

public class UsuarioInexistenteException extends RuntimeException {

    public  UsuarioInexistenteException(String message){
        super(message);
    }
}
