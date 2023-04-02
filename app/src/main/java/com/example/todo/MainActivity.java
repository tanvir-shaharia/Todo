package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import com.example.todo.adapter.TodoAdapter;
import com.example.todo.databinding.ActivityMainBinding;
import com.example.todo.db.TodoDatabase;
import com.example.todo.entities.Todo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    List<Todo> todoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        todoList=new ArrayList<>();
//        Todo todo=new Todo("","","","",01255445);
//        TodoDatabase.getTodoDatabase(MainActivity.this).todo_dao().inserttodo(todo);
        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ADDtodo.class);
                startActivity(intent);
            }
        });
        todoList=TodoDatabase.getTodoDatabase(MainActivity.this).todo_dao().getAlltodo();
        TodoAdapter adapter =new TodoAdapter(todoList,MainActivity.this);
        binding.rechyler.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.item,menu);
        return super.onCreateOptionsMenu(menu);
    }

}