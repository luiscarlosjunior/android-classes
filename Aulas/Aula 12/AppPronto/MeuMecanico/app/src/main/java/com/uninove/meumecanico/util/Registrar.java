package com.uninove.meumecanico.util;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

public class Registrar extends AsyncTask <String, Void, String> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected String doInBackground(String... strings) {
        try{
            String name = "Luis Carlos";
            String username = "lsantos";//(String)arg0[0];
            String password = "123";//(String)arg0[1];
            String link = "http://192.168.56.1:8080/appmeulogin/login.php?name=" + name + "&username="+username+"&password="+password;

            URL url = new URL(link);
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
