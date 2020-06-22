package com.uninove.autocomplemento;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] frutas = {"Banana", "Pêra", "Maça", "Laranja", "Limão", "Caqui", "Jaboticaba", "Ameixa", "Abacaxi"};

        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, Frutas.PegarNomes());

        textView.setAdapter(arrayAdapter);
        textView.setThreshold(1);

    }
}
