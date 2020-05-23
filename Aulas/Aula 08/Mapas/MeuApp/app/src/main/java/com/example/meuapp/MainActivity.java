package com.example.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    final int DURATION = 5000;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tocaMusica();
        animacao();

        // Manipula a thread de execuçao
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginScreen.class);
                startActivity(intent);
                mediaPlayer.stop();
            }
        }, DURATION);
    }

    private void tocaMusica(){
        mediaPlayer = MediaPlayer.create(this, R.raw.oldcarengine);
        mediaPlayer.start();
    }

    private void animacao(){
        ImageView oldcarImage = (ImageView) findViewById(R.id.oldcarView);
        oldcarImage.animate().alpha(0).setDuration(DURATION);
    }
}
