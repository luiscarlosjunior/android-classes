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

public class ValidarLogin extends AsyncTask {
    // Contexto da aplicação
    private Context context;
    private int porMetodo = 0;

    public ValidarLogin(Context context) {
        this.context = context;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        // Utilizando o método GET
        if (porMetodo == 0) {
            try {
                // Faço o meu link para acessar o servidor, passandos os argumentos
                String usuario = "lcarlos"; // Campo de texto usuario;
                String senha = "123"; // Campo de texto da senha;
                String link = "http://192.168.10.20/meuprojeto/login.php?usuario=" + usuario + "&senha="+senha;

                // Fazer a conexão com o servidor
                // Transforma em URL
                URL url = new URL(link);
                //Definir um cliente
                HttpClient client = new DefaultHttpClient();
                // Definir um objeto para requisitar uma resposta
                HttpGet request = new HttpGet();
                // Inicializar o objeto request passando a URL
                request.setURI(new URI(link));
                // Pego o retorno da resposta
                HttpResponse response = client.execute(request);

                // Para poder trabalhar com os textos devolvidos
                BufferedReader reader = new BufferedReader( new InputStreamReader(response.getEntity().getContent()));

                // Auxiliar
                StringBuffer sb = new StringBuffer("");
                String line = "";

                // Ler as respostas que foram retornas
                while((line = reader.readLine()) != null) {
                    sb.append(line);
                }

                return sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
                return new String("Exception: " + e.getMessage());
            }
        } else {
            // Usando o método POST
            try {

                String usuario = "lcarlos"; // Campo de texto usuario;
                String senha = "123"; // Campo de texto da senha;
                String link = "http://192.168.10.20/meuprojeto/login.php";

                // "Monta" os argumentos a serem passados
                String data = URLEncoder.encode("usuario", "UTF-8") +
                                URLEncoder.encode(usuario, "UTF-8");
                data += URLEncoder.encode("senha", "UTF-8") +
                        URLEncoder.encode(senha, "UTF-8");

                URL url = new URL(link);
                URLConnection conn = url.openConnection();

                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                // Escreve os argumentos com os valores
                wr.write(data);
                wr.flush();

                // Para poder trabalhar com os textos devolvidos
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));

                // Auxiliar
                StringBuffer sb = new StringBuffer("");
                String line = "";

                // Ler as respostas que foram retornas
                while((line = reader.readLine()) != null) {
                    sb.append(line);
                }

            } catch (Exception e) {
                // TODO
                e.printStackTrace();
            }

        }


        return null;
    }
}
