package com.example.todo.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.todo.entities.Todo;

import java.util.List;

@Dao
public interface Todo_Dao {

    @Insert
    void inserttodo(Todo todo);

    @Update
    void updatetodo(Todo todo);

    @Delete
    void deletetodo(Todo todo);


    @Query("select * from tbl_todo order by id desc ")
    List<Todo> getAlltodo();
}
