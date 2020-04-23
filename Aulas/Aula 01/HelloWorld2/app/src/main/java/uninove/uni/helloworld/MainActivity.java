package uninove.uni.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void onClick(View view) {
        // Exibe uma msg no console
        // Log.i("Info", "Clicou");
        /*
        EditText editText = findViewById(R.id.userText);

        Toast.makeText(this, editText.getText().toString(), Toast.LENGTH_LONG).show();
        */
        // Login simples
        EditText userText = findViewById(R.id.userText);
        EditText pwdText = findViewById(R.id.pwdText);

        Log.i("Usuário", userText.getText().toString());
        Log.i("Senha", pwdText.getText().toString());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
