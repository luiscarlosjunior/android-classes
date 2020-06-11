package exemplo.webmobile.android.conexaoexterna;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class NovoActivity extends ActionBarActivity {

    private Usuario usuario;
    private EditText editTextNome;
    private EditText editTextEmail;
    private EditText editTextTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo);

        this.usuario = new Usuario();
        this.editTextNome = (EditText) findViewById(R.id.editTextNome);
        this.editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        this.editTextTelefone = (EditText) findViewById(R.id.editTextTelefone);

        Intent intent = getIntent();
        if (intent != null){
            Bundle bundle = intent.getExtras();
            if (bundle != null){
                this.usuario.setId(bundle.getInt("id"));
                this.editTextNome.setText(bundle.getString("nome"));
                this.editTextEmail.setText(bundle.getString("email"));
                this.editTextTelefone.setText(bundle.getString("telefone"));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_novo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void salvar (View view){
        this.usuario.setNome(this.editTextNome.getText().toString());
        this.usuario.setEmail(this.editTextEmail.getText().toString());
        this.usuario.setTelefone(this.editTextTelefone.getText().toString());
        this.usuario.salvar();

        Toast.makeText(this,this.usuario.get_mensagem(),Toast.LENGTH_LONG).show();
        if (usuario.is_status())
            finish();
    }

    public void cancelar (View view){
        finish();
    }
}
