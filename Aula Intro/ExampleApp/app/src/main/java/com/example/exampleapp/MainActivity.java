package com.example.exampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public void clickFuncion(View view) {
        // Instância e inicializa uma variável
        EditText editText = (EditText) findViewById(R.id.editTextView);
        // Cria um log (saída de mensagem no console) para verificar se foi pressionado
        Log.i("Info","Button Pressed");
        // Pega o texto e mostra no console
        Log.i("Values", editText.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
