package com.uninove.meumecanico.util;

import android.content.Context;
import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

public class ValidarEntrada extends AsyncTask <String, Void, String> {

    private Context context;
    private boolean byGetOrPost;

    //flag 0 means get and 1 means post.(By default it is get.)
    public ValidarEntrada(Context context, boolean GetORPOST) {
        this.context = context;
        this.byGetOrPost = GetORPOST;
    }

    @Override
    protected String doInBackground(String... arg0) {
        // Pega o usuário
        if(byGetOrPost){

            try{
                String username = (String)arg0[0];
                String password = (String)arg0[1];
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
                // Faz a inserção dos valores no banco de dados
                String username = "lcarlos";//(String)arg0[0];
                String password = "123";//(String)arg0[1];
                String name = "Santos";
                String link = "http://192.168.56.1:8080/appmeulogin/registro.php?username="+username+"&password="+password+"&name="+name;

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
        }
    }
}
