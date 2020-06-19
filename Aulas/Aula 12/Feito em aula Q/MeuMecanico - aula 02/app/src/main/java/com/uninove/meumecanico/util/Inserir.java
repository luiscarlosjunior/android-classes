package com.uninove.meumecanico.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

public class Inserir extends AsyncTask<String, Void, String> {

    Context context;
    private ProgressDialog carregando;

    public Inserir(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        //super.onPreExecute();
        carregando = ProgressDialog.show(this.context, "Conectando...", "Aguarde um momento...");
    }

    @Override
    protected String doInBackground(String[] strings) {
        // Pega os texto passado no método execute na ordem que foi definido
        String nome = strings[0];
        String usuario =  strings[1];
        String senha =  strings[2];
        String email =  strings[3];
        String link = "http://192.168.56.1:8080/meuapp/inserir.php?" +
                "nome=" + nome + "&usuario=" + usuario + "&senha=" + senha + "&email=" + email;

        try {
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI(link));
            HttpResponse response = client.execute(request);

            BufferedReader bf = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            StringBuffer sb = new StringBuffer("");
            String linha ="";

            while ((linha = bf.readLine()) != null) {
                sb.append(linha);
                //break;
            }

            bf.close();
            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        //super.onPostExecute(s);
        carregando.dismiss();
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }
}
