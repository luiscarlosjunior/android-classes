package com.uninove.meumecanico.util;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.app.ProgressDialog;
import android.widget.Toast;

import com.uninove.meumecanico.MaintenanceUser;
import com.uninove.meumecanico.MapsActivity;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;


public class ValidarEntrada extends AsyncTask <String, Void, String> {
    // Pegar o contexto do aplicativo
    private Context context;
    private int byGetOrPost = 0;
    private ProgressDialog carregando;

    public ValidarEntrada(Context context, int getorpost) {
        this.context = context;
        this.byGetOrPost = getorpost;
    }

    @Override
    protected void onPreExecute() {
        carregando = ProgressDialog.show(this.context, "Conectando...", "Aguarde um momento...");
    }

    @Override
    protected String doInBackground(String[] strings) {

        if (byGetOrPost == 0) {
            // Methodo GET
            String usuario = strings[0]; //"lsantos"; //(String)objects[0];
            String senha = strings[1];//"123";
            String link = "http://192.168.56.1:8080/meuapp/verificaracesso.php?usuario=" + usuario + "&senha=" + senha;

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
        }
        else {
            // Methodo GET
            String usuario =  "lsantos"; //(String)objects[0];
            String senha = "123";
            String link = "http://192.168.56.1:8080/meuapp/verificaracesso.php";

            try {

                // Usar uma classe para codificar
                String data = URLEncoder.encode("usuario", "UTF-8") + " = " +
                        URLEncoder.encode(usuario, "UTF-8");
                data += "&" + URLEncoder.encode("senha", "UTF-8") + " = " +
                        URLEncoder.encode(senha, "UTF-8");

                URL url = new URL(link);
                URLConnection conn = url.openConnection();

                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                wr.write(data);
                wr.flush();

                BufferedReader bf = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                StringBuffer sb = new StringBuffer("");
                String linha ="";

                while ((linha = bf.readLine()) != null) {
                    sb.append(linha);
                    //break;
                }

                return sb.toString();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        //super.onPostExecute(s);
        carregando.dismiss();
        //Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this.context, MaintenanceUser.class);
        context.startActivity(intent);
    }

}
