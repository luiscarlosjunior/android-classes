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

public class ValidarEntrada extends AsyncTask <String, Void, String> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        setNome(s);
        setValido(true);
    }

    //private TextView statusField,roleField;
    private Context context;
    private boolean byGetOrPost;
    private boolean valido;
    private String nome;

    public boolean getValido() {
        return valido;
    }

    private void setValido(boolean valido) {
        this.valido = valido;
    }

    public String getNome() {
        if (getValido()) {
            return nome;
        } else {
            return null;
        }
    }

    private void setNome (String nome) {
        this.nome = nome;
    }

    //flag 0 means get and 1 means post.(By default it is get.)
    public ValidarEntrada(Context context, boolean GetORPOST) {
        this.context = context;
        this.byGetOrPost = GetORPOST;
    }

    @Override
    protected String doInBackground(String[] arg0) {
        if(byGetOrPost){ //means by Get Method

            try{
                String username = "lsantos";//(String)arg0[0];
                String password = "123";//(String)arg0[1];
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

                if (sb.toString().length() > 0) {
                    setValido(true);
                    setNome(sb.toString());
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


}
