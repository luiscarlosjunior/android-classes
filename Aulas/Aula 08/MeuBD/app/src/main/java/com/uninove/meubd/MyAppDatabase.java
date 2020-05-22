package com.uninove.meubd;


import androidx.room.Database;

@Database(entities = {User.class}, version = 1)
public abstract class MyAppDatabase {
    public abstract IDAO idao();
}
