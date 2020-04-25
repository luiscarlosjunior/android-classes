package uninove.uni.meuexemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    final int TEMPO_DE_ATRASO = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animar();

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               Intent intent = new Intent(MainActivity.this, TelaLogin.class);
               startActivity(intent);
               finish();
            }
        }, TEMPO_DE_ATRASO);

    }

    private void animar() {
        ImageView uniView = (ImageView) findViewById(R.id.uninoveView);
        uniView.animate().alpha(0).setDuration(2000);
        // uniView.animate().rotation(360).alpha(0).setDuration(1500);
        // uniView.animate().translationX(1000).setDuration(1500);

    }

}
