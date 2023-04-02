package com.example.todo.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.todo.dao.Todo_Dao;
import com.example.todo.entities.Todo;

@Database(entities = {Todo.class},version = 1)
public abstract class TodoDatabase extends RoomDatabase {

    public abstract Todo_Dao todo_dao();
    public static TodoDatabase todoDatabase = null;
    public static TodoDatabase getTodoDatabase(Context context){

      if (todoDatabase==null){

          todoDatabase = Room.databaseBuilder(
                  context,
                  TodoDatabase.class,
                  "TodoDb"
          ).allowMainThreadQueries().build();

      }return todoDatabase;

    }
}
