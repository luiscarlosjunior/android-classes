package com.uninove.meumecanico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.uninove.meumecanico.util.Autenticar;
import com.uninove.meumecanico.util.ValidarLogin;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
    }

    // Botão entrar
    public void verificar(View view) {
        Context context;

        // Pegar os dados digitados pelo usuário
        EditText usuario = (EditText) findViewById(R.id.edtUsuario);
        EditText senha = (EditText) findViewById(R.id.edtSenha);

        // Declarar duas variáveis strings
        String user = usuario.getText().toString();
        String pwd  = senha.getText().toString();

        ValidarLogin vl = new ValidarLogin(this.getBaseContext());
        vl.execute(user, pwd);

        Autenticar login = new Autenticar();

        login.setUsuario(user);
        login.setSenha(pwd);

        if(login.permissao()) {
            Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Usuário ou senha são inválidos!",
                    Toast.LENGTH_LONG).show();
        }
    }

    // Botão cancelar
    public void cancelar(View view) {
        finishAffinity();
    }

}
