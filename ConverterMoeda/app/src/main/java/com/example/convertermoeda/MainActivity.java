package com.example.convertermoeda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void converterMoeda (View view) {
        // Definindo o tipo de variavel para poder ter acesso as propriedades do campo de texto
        EditText editText = (EditText) findViewById(R.id.editText);

        String montanteEmReais = editText.getText().toString();
        double montanteEmReaisDouble = Double.parseDouble(montanteEmReais);
        double montanteEmDolar = montanteEmReaisDouble * 4.9;

        // Formatar casas decimais para duas após a virgula
        String montanteEmReaisFormat = String.format("%.2f", Double.toString(montanteEmDolar));

        Toast.makeText(this, "R$ " + montanteEmReais + "\n U$ " + montanteEmReaisFormat,
                Toast.LENGTH_LONG).show();
        //Log.i("Montante em dolar: ", Double.toString(montanteEmDolar));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
