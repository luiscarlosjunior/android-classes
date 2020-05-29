package br.com.adsnoobs.sqliteappexemplo.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;

public class Usuario {

    // Atributos
    private int codigo;
    private String nome;
    private String email;
    private String senha;
    private Context context;
    private boolean excluir;

    public Usuario(Context context) {
        this.context = context;
        codigo = -1;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Métodos

    // Exclui dados
    public boolean excluir() {
        DBHelp dbHelp = null;
        SQLiteDatabase sqLiteDatabase = null;

        try {

            dbHelp = new DBHelp(context);
            // Escreve alguma coisa no banco de dados
            sqLiteDatabase = dbHelp.getWritableDatabase();
            //Abrir conexao/transação
            sqLiteDatabase.beginTransaction();

            sqLiteDatabase.delete("registro", "codigo = ?", new String[]{String.valueOf(codigo)});

            excluir = true;

            // Informa que foi um sucesso
            sqLiteDatabase.setTransactionSuccessful();
            // Fechamos a transação
            sqLiteDatabase.endTransaction();

        } catch (Exception e) {
            return false;
        } finally {
            if (sqLiteDatabase != null) {
                sqLiteDatabase.close();
            }
            if (dbHelp != null) {
                dbHelp.close();
            }
        }


    }

    public boolean salvar() {
        DBHelp dbHelp = null;
        SQLiteDatabase sqLiteDatabase = null;

        try {
            dbHelp = new DBHelp(context);
            // Escreve alguma coisa no banco de dados
            sqLiteDatabase = dbHelp.getWritableDatabase();
            String sql = "";

            if (codigo == -1) {
                sql = "INSERT INTO registro (nome, email, senha) VALUES (?, ?, ?)";
            } else {
                sql = "UPDATE registro SET nome = ?, email = ?, senha = ? WHERE codigo = ?";
            }

            // Começar transaçao
            sqLiteDatabase.beginTransaction();

            // Define os parametros
            SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(sql);
            sqLiteStatement.clearBindings();
            sqLiteStatement.bindString(1, nome);
            sqLiteStatement.bindString(2, email);
            sqLiteStatement.bindString(3, senha);

            if (codigo != -1) {
                sqLiteStatement.bindString(4, String.valueOf(codigo));
            }

            sqLiteStatement.executeInsert();
            sqLiteDatabase.setTransactionSuccessful();
            sqLiteDatabase.endTransaction();

            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (sqLiteDatabase != null) {
                sqLiteDatabase.close();
            }
            if (dbHelp != null) {
                dbHelp.close();
            }
        }
    }

    public ArrayList<Usuario> getUsuario() {
        DBHelp dbHelp = null;
        SQLiteDatabase sqLiteDatabase = null;
        Cursor cursor = null;

        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
                dbHelp = new DBHelp(context);
                // Informo que quero ler dados no meu BD
                sqLiteDatabase = dbHelp.getReadableDatabase();

                cursor = sqLiteDatabase.query("usuario", null, null, null, null, null, null);

                while (cursor.moveToNext()) {
                    Usuario usuario = new Usuario(context);
                    usuario.codigo  = cursor.getInt(cursor.getColumnIndex("codigo"));
                    usuario.nome    = cursor.getString(cursor.getColumnIndex("nome"));
                    usuario.senha   = cursor.getString(cursor.getColumnIndex("senha"));
                    usuario.email   = cursor.getString(cursor.getColumnIndex("email"));
                    usuarios.add(usuario);
                }

        } catch (Exception e) {

        } finally {
            if ((cursor != null)) {
                cursor.close();
            }
            // ---
        }
    }

}
