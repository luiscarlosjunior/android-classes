package com.uninove.meumecanico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.uninove.meumecanico.util.Inserir;

public class MaintenanceUser extends AppCompatActivity {
    private Button btnInserir, btnCancelar;
    private EditText edtNome;
    private EditText edtUsuario;
    private EditText edtSenha;
    private EditText edtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance_user);

        btnInserir = (Button) findViewById(R.id.btnInserir);
        btnCancelar = (Button) findViewById(R.id.btnCancelar);

        btnCancelar.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

        btnInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Inserir();
            }
        });
    }

    private void Inserir() {

        // Pega os valores dos campos
        edtNome = (EditText) findViewById(R.id.edtNome);
        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
        edtEmail = (EditText) findViewById(R.id.edtEmail);

        // Depois de pegarmos a referência para esses componentes temos que pegar os textos
        // e converte-los para o tipo String
        String nome = edtNome.getText().toString();
        String usuario = edtUsuario.getText().toString();
        String senha = edtSenha.getText().toString();
        String email = edtEmail.getText().toString();

        AsyncTask execute =  new Inserir(this).execute(nome, usuario, senha, email);
    }
}
