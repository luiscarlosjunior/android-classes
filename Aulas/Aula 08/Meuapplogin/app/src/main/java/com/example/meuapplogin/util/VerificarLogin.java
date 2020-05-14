package com.example.meuapplogin.util;

public class VerificarLogin {
    // Atributos
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

    // Metodos
    public boolean permissao(){
        if (verificarLogin()) {
            return true;
        } else  {
            return false;
        }
    }

    private boolean verificarLogin(){
        return getUsuario().equals("admin") && getSenha().equals("123");
    }
}
