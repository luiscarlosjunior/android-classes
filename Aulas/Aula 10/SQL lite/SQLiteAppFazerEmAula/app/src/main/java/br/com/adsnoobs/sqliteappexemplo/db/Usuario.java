package br.com.adsnoobs.sqliteappexemplo.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;

public class Usuario {
    // Atributos - O que eu tenho
    private int codigo;
    private String nome;
    private String senha;
    private String email;
    private Context context;

    // Construtor
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Métodos - O que eu faço
    public boolean excluir() {
        DBHelper dbHelper = null;
        SQLiteDatabase sqLiteDatabase = null;

        try {
            dbHelper = new DBHelper(context);
            sqLiteDatabase = dbHelper.getWritableDatabase();

            // Começar a transação
            sqLiteDatabase.beginTransaction();

            sqLiteDatabase.delete("usuario", "codigo = ?",new String[]{String.valueOf(codigo)});

            // Informa que foi um sucesso
            sqLiteDatabase.setTransactionSuccessful();
            sqLiteDatabase.endTransaction();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if(sqLiteDatabase != null) {
                sqLiteDatabase.close();
            }

            if(dbHelper != null) {
                dbHelper.close();
            }
        }
    }

    // Método para incluir usuário
    public boolean salvar() {
        DBHelper dbHelper = null;
        SQLiteDatabase sqLiteDatabase = null;

        try {
            dbHelper = new DBHelper(context);
            sqLiteDatabase = dbHelper.getWritableDatabase();
            String sql = null;

            // Verifica se o usuário está sendo incluido ou atualizado
            if(codigo == -1) {
                // Scripts insert
                sql = "INSERT INTO usuario (nome, senha, email) VALUES (?, ?, ?)";
            } else {
                // Script update
                sql = "UPDATE usuario SET nome = ?, senha = ?, email = ? WHERE codigo = ?";
            }
            // Começar a fazer a minha transação
            sqLiteDatabase.beginTransaction();

            // Compilar os dados (Passar os parametros
            SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(sql);

            // Inserir os parametros
            sqLiteStatement.clearBindings();
            sqLiteStatement.bindString(1, nome);
            sqLiteStatement.bindString(2, senha);
            sqLiteStatement.bindString(3, email);

            if(codigo != -1) {
                sqLiteStatement.bindString(4, String.valueOf(codigo));
            }
            // Rodo o script
            sqLiteStatement.executeInsert();

            // Definir a transação como com sucesso
            sqLiteDatabase.setTransactionSuccessful();
            // Encerrando
            sqLiteDatabase.endTransaction();
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if(sqLiteDatabase != null) {
                sqLiteDatabase.close();
            }

            if(dbHelper != null) {
                dbHelper.close();
            }
        }
    }

    // pego todos as linhas do banco
    public ArrayList<Usuario> getUsuario() {
        DBHelper dbHelper = null;
        SQLiteDatabase sqLiteDatabase = null;

        Cursor cursor = null;
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            dbHelper = new DBHelper(context);
            sqLiteDatabase = dbHelper.getReadableDatabase();

            cursor = sqLiteDatabase.query("usuario", null, null, null, null, null, null);

            while(cursor.moveToNext()) {
                Usuario usuario = new Usuario(context);
                usuario.codigo = cursor.getInt(cursor.getColumnIndex("codigo"));
                usuario.nome = cursor.getString(cursor.getColumnIndex("nome"));
                usuario.senha = cursor.getString(cursor.getColumnIndex("senha"));
                usuario.email = cursor.getString(cursor.getColumnIndex("email"));

                usuarios.add(usuario);
            }

        } catch (Exception e){

        } finally {

            if ( cursor != null && !cursor.isClosed()) {
                cursor.close();
            }

            if(sqLiteDatabase != null) {
                sqLiteDatabase.close();
            }

            if(dbHelper != null) {
                dbHelper.close();
            }
        }
        return usuarios;
    }
}
