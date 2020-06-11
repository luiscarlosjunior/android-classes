package exemplo.webmobile.android.conexaoexterna;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class UsuarioAdapter extends ArrayAdapter<Usuario> {
    private Context context;
    private ArrayList<Usuario> lista;

    public UsuarioAdapter(Context context, ArrayList<Usuario> lista){
        super(context,0,lista);
        this.context = context;
        this.lista = lista;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Usuario itemPosicao = this.lista.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.item_lista,null);
        final View layout = convertView;

        TextView textView = (TextView) convertView.findViewById(R.id.textViewNome);
        textView.setText(itemPosicao.getNome());

        TextView textViewEmail = (TextView) convertView.findViewById(R.id.textViewEmail);
        textViewEmail.setText(itemPosicao.getEmail());

        TextView textViewTelefone = (TextView) convertView.findViewById(R.id.textViewTelefone);
        textViewTelefone.setText(itemPosicao.getTelefone());

        Button button = (Button)convertView.findViewById(R.id.buttonEditar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,NovoActivity.class);
                intent.putExtra("telefone",itemPosicao.getTelefone());
                intent.putExtra("nome",itemPosicao.getNome());
                intent.putExtra("email",itemPosicao.getEmail());
                intent.putExtra("id",itemPosicao.getId());
                context.startActivity(intent);
            }
        });

        Button buttonDeletar = (Button)convertView.findViewById(R.id.buttonApagar);
        buttonDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemPosicao.apagar();
                if (itemPosicao._status)
                    layout.setVisibility(View.GONE);
                else
                    Toast.makeText(context,itemPosicao.get_mensagem(),Toast.LENGTH_LONG).show();
            }
        });

        return convertView;
    }
}
