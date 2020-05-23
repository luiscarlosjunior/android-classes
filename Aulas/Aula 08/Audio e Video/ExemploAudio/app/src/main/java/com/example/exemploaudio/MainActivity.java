package com.example.exemploaudio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import java.nio.file.Files;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    // Definir dois objectos para poder manipular
    MediaPlayer mediaPlayer;
    AudioManager audioManager;

    public void tocar(View view) {
        mediaPlayer.start();
    }

    public void pausar(View view) {
        mediaPlayer.pause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar nossos objetos
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        mediaPlayer = MediaPlayer.create(this, R.raw.caralarm);

        // Método que define o uso do Progress bar
        defineProgressBar();

        defineMusicaProgressBar();
    }

    private void defineMusicaProgressBar() {
        // Faz um referência ao componente que será responsavel por permitir a visualização
        // do progresso da música
        final SeekBar seekBar = (SeekBar) findViewById(R.id.musicaBar);

        // Pegando a duração da musica
        int duracaoMusica = mediaPlayer.getDuration();
        // Define o tamanho máxima da duração
        seekBar.setMax(duracaoMusica);

        // Faz uso do listener 'ouvinte' para atualizar o progressBar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mediaPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        /*
        Esse trecho de código é responsável por realizar a transição do inicio ao fim
        da música
        */
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
            }
        }, 0, 2000);

    }

    private void defineProgressBar() {

        // Pegando o volume máximo do aparelho
        int volumeMax = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        // Faço referencia ao volumeBar da tela
        SeekBar volumeBar = (SeekBar) findViewById(R.id.volumeBar);

        volumeBar.setMax(volumeMax);
        volumeBar.setProgress(volumeMax/2);

        volumeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int volume, boolean fromUser) {
                //Log.i("Movimentando:", Integer.toString(progress));
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, volume, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
