package com.uninove.minitab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /*
    public void goPic(View view) {
        enterPictureInPictureMode();
    }
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnClick = findViewById(R.id.button);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enterPictureInPictureMode();
            }
        });

    }

    @Override
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);

        TextView textView = findViewById(R.id.textView);
        Button pipButton = findViewById(R.id.button);

        if (isInPictureInPictureMode) {
            pipButton.setVisibility(View.INVISIBLE);
            getSupportActionBar().hide();
            textView.setTextColor(Color.BLACK);
            textView.setTextSize(18f);
            textView.setText("R$ 15.555,36");
        }
        else
        {
            pipButton.setVisibility(View.VISIBLE);
            getSupportActionBar().show();
            textView.setTextColor(Color.BLACK);
            textView.setTextSize(18f);
            textView.setText("R$ 15.555,36");
        }
    }
}
