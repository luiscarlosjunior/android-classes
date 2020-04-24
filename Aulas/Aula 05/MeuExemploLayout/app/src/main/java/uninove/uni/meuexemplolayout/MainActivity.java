package uninove.uni.meuexemplolayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    // Define uma constante de atraso em milisegundos
    final int TEMPO_DE_ATRASO = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animar();

        // Cria um objeto para manipular as threads de execução
        Handler handler = new Handler();

        // Inicializo o objeto com dois parametros
        handler.postDelayed( new Runnable() {
            public void run() {
                // Faz a conexão com a outra activity
                Intent intent = new Intent(MainActivity.this, TelaLogin.class);
                startActivity(intent);
                finish();
            }
        }, TEMPO_DE_ATRASO);
    }

    // Método para realizar a animação
    private void animar() {
        // Faz a referencia ao objeto uniView (imagem da tela principal)
        ImageView img = (ImageView) findViewById(R.id.uninoveView);
        // Define alguns tipos de animações
        img.animate().translationX(1000).setDuration(4000);
    }

}
