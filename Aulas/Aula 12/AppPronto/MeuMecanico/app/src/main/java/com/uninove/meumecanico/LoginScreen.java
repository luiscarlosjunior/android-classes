package com.uninove.meumecanico;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.uninove.meumecanico.util.ValidarEntrada;

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

        //ValidarEntrada vc = new ValidarEntrada(getBaseContext());

        //vc.execute(usuario, senha);

        AsyncTask execute = new ValidarEntrada(this).execute(usuario, senha);

        // Declarar duas variáveis strings
        //String user = usuario.getText().toString();
        //String pwd  = senha.getText().toString();

        //Autenticar login = new Autenticar();

        //login.setUsuario(user);
        //login.setSenha(pwd);

        //if(login.permissao()) {
            //Intent intent = new Intent(this, MapsActivity.class);
            //startActivity(intent);
        //} else {
            //Toast.makeText(this, "Usuário ou senha são inválidos!",
                    //.LENGTH_LONG).show();
        //}
    }

    // Botão cancelar
    public void cancelar(View view) {
        finishAffinity();
    }

}
