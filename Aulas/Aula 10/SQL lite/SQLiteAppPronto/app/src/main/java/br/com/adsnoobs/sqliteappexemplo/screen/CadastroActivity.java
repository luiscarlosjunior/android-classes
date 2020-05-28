package br.com.adsnoobs.sqliteappexemplo.screen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

// API SQLite
import br.com.adsnoobs.sqliteappexemplo.R;
import br.com.adsnoobs.sqliteappexemplo.db.Usuario;

public class CadastroActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtSenha;
    private Button btnExcluir;
    private Button btnSalvar;
    private Button btnCancelar;

    // Cria um contexto para o projeto
    private final Usuario usuario = new Usuario(this);

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
            int codigo = getIntent().getExtras().getInt("consulta");
            usuario.carregaUsuarioPeloCodigo(codigo);

            edtNome.setText(usuario.getNome());
            edtEmail.setText(usuario.getEmail());
            edtSenha.setText(usuario.getSenha());
        }else{
            setTitle(getString(R.string.titulo_incluindo));
        }

        btnExcluir.setEnabled(true);
        if (usuario.getCodigo() == -1)
            btnExcluir.setEnabled(false);
    }


    /*
    *
    * */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonCancelar : {
                // Encerra a tela corrente
                finish();
                break;
            }
            case R.id.buttonExcluir : {
                // Exclui e encerra a página
                usuario.excluir();
                finish();
                break;
            }
            case R.id.buttonSalvar :{
                boolean valido = true;
                usuario.setNome(edtNome.getText().toString().trim());
                usuario.setEmail(edtEmail.getText().toString().trim().toLowerCase());
                usuario.setSenha(edtSenha.getText().toString().trim());

                if (usuario.getNome().equals("")){
                    edtNome.setError(getString(R.string.obrigatorio));
                    valido = false;
                }

                if (usuario.getEmail().equals("")){
                    edtEmail.setError(getString(R.string.obrigatorio));
                    valido = false;
                }

                if (usuario.getSenha().equals("")){
                    edtSenha.setError(getString(R.string.obrigatorio));
                    valido = false;
                }

                if (valido){
                    usuario.salvar();
                    finish();
                }
                break;
            }
        }
    }
}
