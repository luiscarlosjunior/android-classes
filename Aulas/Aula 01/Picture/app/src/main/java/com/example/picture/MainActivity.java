package com.example.picture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void trocarImagem(View view) {
       ImageView imagem = (ImageView) findViewById(R.id.imageView);
       imagem.setImageResource(R.drawable.dog2);
    }

    public void trocarImagem2(View view) {
        ImageView imagem = (ImageView) findViewById(R.id.imageView);
        imagem.setImageResource(R.drawable.dog1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
