package com.example.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.meuapp.util.Validar;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
    }

    public void validarEntrada(View view) {
        EditText usuario = (EditText) findViewById(R.id.edtUser);
        EditText senha = (EditText) findViewById(R.id.edtPwd);

        // Declara e inicializa a string com os valores digitados
        String user     = usuario.getText().toString();
        String password = senha.getText().toString();

        // Cria um novo objeto
        Validar login = new Validar();

        login.setUsuario(user);
        login.setSenha(password);

        // Verifica se tem eprmissão ou não
        if(login.permissao()) {
            Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Login ou Senha estão incorretos", Toast.LENGTH_SHORT).show();
        }
    }

    public void cancelar(View view) {
        finishAffinity();
    }
}
