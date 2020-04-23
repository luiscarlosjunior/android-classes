package uninove.uni.exemplologin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void AbrirOutraTela(View view) {
        Intent intent = new Intent(this, Tela02.class);
        startActivity(intent);

    }

    public void somaValor(View view) {
        EditText valor1 = (EditText) findViewById(R.id.editTextN1);
        EditText valor2 = (EditText) findViewById(R.id.editTextN2);

        int v1 = Integer.parseInt(valor1.getText().toString());
        int v2 = Integer.parseInt(valor2.getText().toString());

        Toast.makeText(this, "A some é: " + (v1 + v2), Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
