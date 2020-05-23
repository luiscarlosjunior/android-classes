package com.example.meuapp.util;

public class Validar {
    // Abstração

    // O que ele tem - Atributos
    private String Usuario;
    private String Senha;

    // Encapsulamento
    private String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    private String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    // O que ele pode fazer - Métodos
    public boolean permissao() {
        return autenticarUsuario();
    }

    private boolean autenticarUsuario() {

        return getUsuario().equals("admin") && getSenha().equals("123");

        /*
        if (getUsuario().equals("admin") && getSenha().equals("123")) {
            return true;
        } else {
            return false;
        }
        */
    }

    // Como que ele está naquele momento - Situação
    //Logado
    //Deslogado

}
