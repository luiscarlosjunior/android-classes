package com.uninove.meumecanico.util;

import android.content.Context;
import android.os.AsyncTask;

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

public class ValidarEntrada extends AsyncTask {
    // Pegar o contexto do aplicativo
    private Context context;
    private int byGetOrPost = 0;

    public ValidarEntrada(Context context, int getorpost) {
        this.context = context;
        this.byGetOrPost = getorpost;
    }

    @Override
    protected Object doInBackground(Object[] objects) {

        if (byGetOrPost == 0) {
            // Methodo GET
            String usuario =  "lsantos"; //(String)objects[0];
            String senha = "123";
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
}
