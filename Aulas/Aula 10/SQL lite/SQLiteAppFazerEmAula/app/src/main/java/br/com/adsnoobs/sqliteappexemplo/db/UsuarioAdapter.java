package br.com.adsnoobs.sqliteappexemplo.db;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.adsnoobs.sqliteappexemplo.R;

public class UsuarioAdapter extends ArrayAdapter<Usuario> {

    private ArrayList<Usuario> usuarios;

    //Construtor
    public UsuarioAdapter(@NonNull Context context, @NonNull ArrayList<Usuario> usuarios) {
        super(context, 0,  usuarios);
        this.usuarios = usuarios;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Usuario usuario = usuarios.get(position);

        // Atribuir o layout para a view - converter
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_usuario, null);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageViewAvatar);
        TextView txtNome = (TextView) convertView.findViewById(R.id.textViewNome);
        TextView txtEmail = (TextView) convertView.findViewById(R.id.textViewEmail);

        txtNome.setText(usuario.getNome());
        txtEmail.setText(usuario.getEmail());

        return convertView;
    }
}
