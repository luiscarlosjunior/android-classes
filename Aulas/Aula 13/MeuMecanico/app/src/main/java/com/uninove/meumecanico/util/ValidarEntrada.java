package com.uninove.meumecanico.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.uninove.meumecanico.Maintenance;

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

    private Context context;
    private boolean byGetOrPost;
    //Declarando
    private ProgressDialog carregando;

    //flag 0 means get and 1 means post.(By default it is get.)
    public ValidarEntrada(Context context, boolean GetORPOST) {
        this.context = context;
        this.byGetOrPost = GetORPOST;
    }

    // Executa antes da thread
    @Override
    protected void onPreExecute() {
        carregando = ProgressDialog.show(this.context, "Conectando...",
                "Aguarde um momento");
    }

    @Override
    protected String doInBackground(String[] strings) {
        if(byGetOrPost){ //means by Get Method
            try{
                String username = strings[0];
                String password = strings[1];
                String link = "http://192.168.56.1:8080/appmeulogin/login.php?username="+username+"&password="+password;

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
                    break;
                }

                in.close();

                return sb.toString();
            } catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }
        } else{
            try{
                String username = "lcarlos";//(String)arg0[0];
                String password = "123";//(String)arg0[1];

                String link="http://192.168.56.1:8080/appmeulogin/login.php";
                String data  = URLEncoder.encode("username", "UTF-8") + "=" +
                        URLEncoder.encode(username, "UTF-8");
                data += "&" + URLEncoder.encode("password", "UTF-8") + "=" +
                        URLEncoder.encode(password, "UTF-8");

                URL url = new URL(link);
                URLConnection conn = url.openConnection();

                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                wr.write( data );
                wr.flush();

                BufferedReader reader = new BufferedReader(new
                        InputStreamReader(conn.getInputStream()));

                StringBuilder sb = new StringBuilder();
                String line = null;

                // Read Server Response
                while((line = reader.readLine()) != null) {
                    sb.append(line);
                    break;
                }

                return sb.toString();
            } catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }
        }
    }

    // Executa depois que termina a thread - Retorna para a thread principal
    @Override
    protected void onPostExecute(String s) {
        //super.onPostExecute(s);
        carregando.dismiss();
        //Toast.makeText(context, s, Toast.LENGTH_LONG).show();

        // Ir para a outra tela
        Intent intent = new Intent(this.context, Maintenance.class);
        context.startActivity(intent);
    }
}
