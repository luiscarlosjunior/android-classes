package com.example.meuprimeiroapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import util.Login;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
    }

    // Botão Login
    public void login(View view) {
        EditText user = (EditText) findViewById(R.id.edtUser);
        EditText pwd = (EditText) findViewById(R.id.edtPassword);

        String usuario = user.getText().toString();
        String senha = pwd.getText().toString();

        if (retornaAcesso(usuario, senha)) {
            chamaMainPage();
        }
        else {
            Toast.makeText(this, "Não foi possível fazer o login, tente novamente",
                    Toast.LENGTH_SHORT).show();
        }

    }
    // Botão cancelar
    public void cancelar(View view) {
        finishAffinity();
    }

    private boolean retornaAcesso(String usuario, String senha) {
        Login login = new Login();

        login.setUsuario(usuario);
        login.setSenha(senha);

        return login.permissao();
    }

    private void chamaMainPage(){
        //Intent intent = new Intent(Lo)
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

}
