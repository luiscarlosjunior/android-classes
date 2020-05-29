package br.com.adsnoobs.sqliteappexemplo.screen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

// API SQLite
import br.com.adsnoobs.sqliteappexemplo.R;

public class CadastroActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtSenha;
    private Button btnExcluir;
    private Button btnSalvar;
    private Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edtNome = (EditText)findViewById(R.id.editTextNome);
        edtEmail = (EditText)findViewById(R.id.editTextEmail);
        edtSenha = (EditText)findViewById(R.id.editTextSenha);
        btnExcluir = (Button)findViewById(R.id.buttonExcluir);
        btnCancelar = (Button)findViewById(R.id.buttonCancelar);
        btnSalvar = (Button)findViewById(R.id.buttonSalvar);

        btnExcluir.setOnClickListener(this);
        btnSalvar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);

        if (getIntent().getExtras() != null){
            setTitle(getString(R.string.titulo_editando));

        }else{
            setTitle(getString(R.string.titulo_incluindo));
        }

        btnExcluir.setEnabled(true);

    }

    /*
    *
    * */
    @Override
    public void onClick(View v) {

    }
}
