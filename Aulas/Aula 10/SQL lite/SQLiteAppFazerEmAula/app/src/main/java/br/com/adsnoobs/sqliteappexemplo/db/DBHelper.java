package br.com.adsnoobs.sqliteappexemplo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    // Define o nome do banco
    private static String NOME = "registro_usuario.db";
    // Define a versão
    private static int VERSAO = 1;

    public DBHelper (Context context) {
        super(context, NOME, null, VERSAO);
    }

    // Criar os scripts quando não encontra o nome e a versão do banco de dados
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE usuario ( codigo INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        " nome   VARCHAR (50) NOT NULL," +
                        " senha  VARCHAR (50)," +
                        " email  VARCHAR (50) " +
                        ");"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
