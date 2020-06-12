package com.uninove.meumecanico;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.uninove.meumecanico.util.Autenticar;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
    }

    // Botão entrar
    public void verificar(View view) {
        // Pegar os dados digitados pelo usuário
        EditText usuario = (EditText) findViewById(R.id.edtUsuario);
        EditText senha = (EditText) findViewById(R.id.edtSenha);

        // Declarar duas variáveis strings
        String user = usuario.getText().toString();
        String pwd  = senha.getText().toString();

        Autenticar login = new Autenticar();

        login.setUsuario(user);
        login.setSenha(pwd);

        if(login.permissao()) {
            Intent intent = new Intent(this, RegistrarUsuario.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Usuário ou senha são inválidos!", Toast.LENGTH_SHORT).show();
        }
    }

    // Botão cancelar
    public void cancelar(View view) {
        //finishAffinity();
    }

}
