package com.uninove.meumecanico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    final int DURACAO = 5000;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animacao();
        // Executando o aúdio
        mediaPlayer = MediaPlayer.create(this, R.raw.oldcarengine);
        mediaPlayer.start();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginScreen.class);
                startActivity(intent);
                mediaPlayer.stop();
                finish();
            }
        }, DURACAO);
    }

    private void animacao() {
        ImageView imageView = (ImageView) findViewById(R.id.oldcarView);
        imageView.animate().alpha(0).setDuration(DURACAO);
    }
}
