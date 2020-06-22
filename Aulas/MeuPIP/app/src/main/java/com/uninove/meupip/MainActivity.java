package com.uninove.meupip;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClick = findViewById(R.id.btnDiminuir);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterPictureInPictureMode();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);

        TextView txtView = findViewById(R.id.textView);
        btnClick = findViewById(R.id.btnDiminuir);

        if (isInPictureInPictureMode) {
            btnClick.setVisibility(View.INVISIBLE);
            Objects.requireNonNull(getSupportActionBar()).hide();
            txtView.setTextSize(22f);
            txtView.setText("R$ 10.000,00");
        } else {
            btnClick.setVisibility(View.VISIBLE);
            Objects.requireNonNull(getSupportActionBar()).show();
            txtView.setTextSize(18f);
            txtView.setText("Hello world");
        }

    }
}
