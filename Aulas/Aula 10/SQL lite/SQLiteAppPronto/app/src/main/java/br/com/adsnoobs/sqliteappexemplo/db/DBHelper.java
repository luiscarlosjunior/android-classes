package br.com.adsnoobs.sqliteappexemplo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// Esta classe onde é feita todo o processo de criação e armazenamento
public class DBHelper extends SQLiteOpenHelper {

    // Nome do banco a ser criado
    private static String NOME = "registro_teste.db";
    // Versão do banco
    private static int VERSAO = 1;

    // Esse método é responsável por criar/atualizar o banco de dados
    public DBHelper(Context context){
        super(context,NOME,null,VERSAO);
    }

    /*
    * Essa função faz a criaçao da tabela
    * */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
            "CREATE TABLE [usuario] (\n" +
            "[codigo] INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
            "[nome] VARCHAR(60)  NOT NULL,\n" +
            "[email] VARCHAR(60)  NOT NULL,\n" +
            "[senha] VARCHAR(60)  NOT NULL )"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
