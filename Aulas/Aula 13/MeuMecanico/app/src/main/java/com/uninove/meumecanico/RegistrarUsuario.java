package com.uninove.meumecanico;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.uninove.meumecanico.util.Registrar;

public class RegistrarUsuario extends AppCompatActivity {

    private EditText nome, usuario, senha, email;
    private Button btnRegistro;
    private static String URL_REGISTRO = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);


    }

    public void registro(View view) {

        EditText edtNome = (EditText) findViewById(R.id.edtNome);
        EditText edtUser = (EditText) findViewById(R.id.edtUsuario);
        EditText edtSenha = (EditText) findViewById(R.id.edtSenha);
        EditText edtemail = (EditText) findViewById(R.id.edtemail);

        AsyncTask execute = new Registrar(this).execute("Luis Carlos", "lcarlos", "123");

    }

}
