package br.com.adsnoobs.sqliteappexemplo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// Importa as duas janelas
import br.com.adsnoobs.sqliteappexemplo.screen.CadastroActivity;
import br.com.adsnoobs.sqliteappexemplo.screen.ConsultaActivity;

public class MainActivity extends AppCompatActivity {

    // Declaração dos objetos
    private Button btnConsultar;
    private Button btnIncluir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConsultar = (Button)findViewById(R.id.buttonConsultar);
        btnIncluir = (Button)findViewById(R.id.buttonIncluir);

        // Forma resumida de chamar o botão
        // Invés de fazer uma função para cada, criamos um evento listener para cada um
        btnIncluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConsultaActivity.class);
                startActivity(intent);
            }
        });
    }
}
