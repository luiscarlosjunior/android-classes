package uninove.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void fade(View view) {
        ImageView bartView1 = (ImageView) findViewById(R.id.bartView);
        ImageView homerViewImage = (ImageView) findViewById(R.id.homerView);

        // O trecho de código abaixo pega o tamanho da tela do dispositivo
        /*
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int altura = displayMetrics.heightPixels;
        int tamanho = displayMetrics.widthPixels;
        */
        //Toast.makeText(this, "Altura " + altura + "\n Largura: " + tamanho, Toast.LENGTH_LONG).show();

        //Translation
         //bartView1.animate().translationXBy(1000).setDuration(2000);

        // Rotation
        // bartView1.animate().rotation(1800).alpha(0).setDuration(1000);

         bartView1.animate().scaleX(0.5f).scaleY(0.5f).setDuration(1000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        ImageView bartImageView = (ImageView) findViewById(R.id.bartView);
        bartImageView.animate().translationXBy(-1000);
        bartImageView.animate().translationXBy(1000).rotation(3600).setDuration(2000);
        */
    }
}
