package com.uninove.meumecanico.util;

public class Autenticar {

    // Coisas que o login tem - Atributos
    private String usuario;
    private String senha;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    private String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Coisas que o objeto faz - Métodos
    public boolean permissao() {
        return autenticar();
    }

    private boolean autenticar() {
        // return getUsuario().equals("admin") && getSenha().equals("123");

        if (getUsuario().equals("admin") && getSenha().equals("123")) {
            return true;
        } else {
            return false;
        }
    }


    // Como o objeto está no momento - Situação
    //Desconectado
    //Conectado
    //Sem senha
}
