package com.uninove.meumecanico;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrarUsuario extends AppCompatActivity {

    private EditText nome, usuario, senha, email;
    private Button btnRegistro;
    private static String URL_REGISTRO = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        nome = findViewById(R.id.edtNome);
        usuario = findViewById(R.id.edtUsuario);
        senha = findViewById(R.id.edtSenha);
        email = findViewById(R.id.edtemail);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // TODO
            }
        });

    }

    private void registro() {
        btnRegistro.setVisibility(View.GONE);

        final String nome = this.nome.getText().toString().trim();
        final String usuario = this.usuario.getText().toString().trim();
        final String senha = this.usuario.getText().toString().trim();
        final String email = this.usuario.getText().toString().trim();


    }

}
