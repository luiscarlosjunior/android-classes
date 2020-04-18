package uninove.uni.meulogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class boasVindas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boas_vindas);
    }
    
    public void verificarLogin(View view) {

        EditText usuario = findViewById(R.id.etUsuario);
        EditText senha = findViewById(R.id.etSenha);

        // Pega o texto
        String textoUsuario = usuario.getText().toString();
        String textoSenha = senha.getText().toString();

        // Verifica se é válido
        if (textoUsuario.equals("admin") && textoSenha.equals("1234")) {
            Toast.makeText(this, "Entrada válida", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, "Entrada inválida", Toast.LENGTH_SHORT).show();
        }
        // Boa noite pessoal!
        // Pelo horário fui desconectado.
        Bom final de semana, abraços!

    }
}
