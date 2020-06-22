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

public class Registrar extends AsyncTask <String, Void, String> {
    private Context context;
    private ProgressDialog inserindo;

    public Registrar (Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        inserindo = ProgressDialog.show(this.context, "Inserindo..",
                "Realizando a inserção de usuário...");
    }

    @Override
    protected String doInBackground(String[] strings) {
        try{

            String name = strings[0];
            String username = strings[1];
            String password = strings[2];
            String email = strings[3];

            String link = "http://192.168.56.1:8080/meuapp/inserir.php?nome=" +name+"&usuario="
                    +username+"&senha="+password+"&email=" + email;

            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet();
            request.setURI(new URI(link));
            HttpResponse response = client.execute(request);
            BufferedReader in = new BufferedReader(new
                    InputStreamReader(response.getEntity().getContent()));

            StringBuffer sb = new StringBuffer("");
            String line="";

            while ((line = in.readLine()) != null) {
                sb.append(line);
                //break;
            }

            in.close();

            return sb.toString();
        } catch(Exception e){
            return new String("Exception: " + e.getMessage());
        }
    }

    @Override
    protected void onPostExecute(String s) {
        inserindo.dismiss();
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }

}
