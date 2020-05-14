package com.example.meuapplogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    final int DURATION = 6000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageAnimation();
        music();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
                finish();
                mediaPlayer.pause();
            }
        }, DURATION);
    }

    private void imageAnimation() {
        ImageView imageView = (ImageView) findViewById(R.id.oldcarView);
        imageView.animate().alpha(0).scaleX(-2.0f).scaleY(-2.0f).setDuration(DURATION);
    }

    private void music(){
        mediaPlayer = MediaPlayer.create(this, R.raw.oldcarengine);
        mediaPlayer.start();
    }
}
