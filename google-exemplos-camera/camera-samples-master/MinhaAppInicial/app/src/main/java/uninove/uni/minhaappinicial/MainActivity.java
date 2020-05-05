package uninove.uni.minhaappinicial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView bartImageView = (ImageView) findViewById(R.id.bartView);
        // bartImageView.animate().translationXBy(-1000);
        bartImageView.animate().alpha(0).setDuration(2000);
        // bartImageView.animate().translationXBy(1000).setDuration(2000);
    }
}
