package uninove.uni.exemplosoma;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public void somaValores(View view) {

        EditText valor1 = (EditText) findViewById(R.id.valor1);
        EditText valor2 = (EditText) findViewById(R.id.valor2);

        int soma = Integer.parseInt(valor1.getText().toString()) + Integer.parseInt(valor2.getText().toString());

        Toast.makeText(this, "A soma é " + soma, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
