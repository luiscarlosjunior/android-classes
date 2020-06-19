package com.uninove.iconesadaptativos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        EditText texto = findViewById(R.id.editText);
        texto.setAutofillHints(View.AUTOFILL_HINT_NAME);

        String[] amigos = {"Luis", "Rodrigo", "Jonathan", "Jorge", "Lais"};

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, Nomes.PegarValores());

        autoCompleteTextView.setAdapter(arrayAdapter);
        autoCompleteTextView.setTextScaleX(0.9f);
        autoCompleteTextView.setThreshold(1);


    }



}
