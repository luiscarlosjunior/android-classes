package br.com.adsnoobs.sqliteappexemplo.screen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.adsnoobs.sqliteappexemplo.R;

public class ConsultaActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ListView listViewUsuarios;
    private Button btnFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        btnFechar = (Button)findViewById(R.id.buttonFechar);
        btnFechar.setOnClickListener(this);

        listViewUsuarios = (ListView)findViewById(R.id.listViewUsuarios);
        listViewUsuarios.setOnItemClickListener(this);


    }

    @Override
    public void onClick(View v) {
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
