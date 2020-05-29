package br.com.adsnoobs.sqliteappexemplo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelp extends SQLiteOpenHelper {

    private static String NOME = "registro.db";
    private static int VERSAO = 1;

    // Construtor
    public DBHelp (Context context) {
        super(context, NOME, null, VERSAO);
    }

    // Criação de tabela
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "CREATE TABLE registro ( codigo INTEGER PRIMARY KEY, nome VARCHAR(50) NOT NULL, email  VARCHAR(50), senha  VARCHAR(50) );"
        );

    }

    // Atualiza o banco/tabelas
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
