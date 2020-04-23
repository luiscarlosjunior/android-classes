package uninove.uni.meulogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void verificarLogin(View view) {

        EditText usuario = findViewById(R.id.etUsuario);
        EditText senha = findViewById(R.id.etSenha);

        if (verificarEntradas(usuario.getText().toString(), senha.getText().toString())) {
            iniciarTelaBoasVindas();
        }
        else {
            Toast.makeText(this, "Login inválido", Toast.LENGTH_SHORT).show();
        }
    }

    private void iniciarTelaBoasVindas() {
        Intent intent = new Intent(this, boasVindas.class);
        startActivity(intent);
    }

    private boolean verificarEntradas(String usuario, String senha) {
        if (usuario.equals("admin") && senha.equals("1234")) {
            return true;
        }
        else {
            return true;
        }
    }
}
