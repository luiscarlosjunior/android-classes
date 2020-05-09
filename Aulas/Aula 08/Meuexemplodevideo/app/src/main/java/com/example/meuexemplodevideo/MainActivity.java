package com.example.meuexemplodevideo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Faz referência ao componente
        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        // link o video com o componente
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.demovideo);

        // O medi
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);

        videoView.setMediaController(mediaController);
        videoView.start();

    }
}
