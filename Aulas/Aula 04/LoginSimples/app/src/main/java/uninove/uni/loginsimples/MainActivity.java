package uninove.uni.loginsimples;

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

    // Função para realizar a validação
    public void verificarAcesso(View view) {
        // É criada a instância da classe EditText e atribuido valor;

        EditText usuario = findViewById(R.id.userText);
        EditText senha =  findViewById(R.id.pwdText);

        // São declaradas duas variaveis do tipo String e são atribuidas os textos dos respectivos
        // campos de texto
        String strUser = usuario.getText().toString();
        String strSenha = senha.getText().toString();

        // Faz uma verificar se o usuário é valido
        if(verificarLogin(strUser, strSenha)) {
            chamarOutraTela();
        }
        else
        {
            Toast.makeText(this, "Login inválido", Toast.LENGTH_LONG).show();
        }
    }

    private boolean verificarLogin(String usuario, String senha) {

        if (usuario.equals("admin") && senha.equals("1234")) {
            return true;
        }
        else
        {
            return false;
        }
    }

    private void chamarOutraTela() {
        // É criado e instânciado um novo objeto
        Intent intent = new Intent(this, TelaInicial.class);
        startActivity(intent);
    }

}
