package com.uninove.meubd;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface IDAO {
    @Insert
    public void addUser(User use);
}
