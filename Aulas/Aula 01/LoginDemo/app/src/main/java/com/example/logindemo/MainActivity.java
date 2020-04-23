package com.example.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void login(View view) {
        // Encontra os recursos (campos) pelo id
        EditText userText = (EditText) findViewById(R.id.userName);
        EditText pwdText = (EditText) findViewById(R.id.senhaUser);

        Log.i("Usuário", userText.getText().toString());
        Log.i("Senha", pwdText.getText().toString());

        Toast.makeText(this, "Olá, tudo bem? \r" + userText.getText().toString(), Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
