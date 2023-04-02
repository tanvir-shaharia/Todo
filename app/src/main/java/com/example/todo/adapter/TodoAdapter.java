package com.example.todo.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todo.EDITActivity;
import com.example.todo.R;
import com.example.todo.db.TodoDatabase;
import com.example.todo.entities.Todo;
import com.example.todo.viewHolder.TodoViewholder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoViewholder> {
    List<Todo> todoList;
    Context context;

    public TodoAdapter(List<Todo> todoList, Context context) {
        this.todoList = todoList;
        this.context = context;
    }

    @NonNull
    @Override
    public TodoViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.todo_item,parent,false);
        return new TodoViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewholder holder, int position) {

        Todo todo =todoList.get(position);
        Date date =new Date(todo.getDate());
        DateFormat dt =new SimpleDateFormat("dd/MM/yyyy hh:mm a ");

        holder.tittle.setText(todo.getTitle());
        holder.todotask.setText(todo.getTodotask());
        holder.date.setText(dt.format(date));
        holder.priority.setText(todo.getPriority());
        holder.catagory.setText(todo.getCatagory());

        holder.delete.setOnClickListener(view -> {
           deletealert(context,todo);
        });
        holder.edit.setOnClickListener(view -> {
            Intent intent=new Intent(context, EDITActivity.class);
            intent.putExtra("id",todo.getId());
            intent.putExtra("tittle",todo.getTitle());
            intent.putExtra("todotask",todo.getTodotask());
            intent.putExtra("catagory",todo.getCatagory());
            intent.putExtra("priority",todo.getPriority());
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public  void deletealert(Context context,Todo todo){
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setTitle("Delete")
                .setIcon(R.drawable.ic_baseline_delete_24)
                .setMessage("Are you sure to Delete?")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        TodoDatabase.getTodoDatabase(context).todo_dao().deletetodo(todo);
                        Intent intent=new Intent(context,context.getClass());
                        context.startActivity(intent);

                    }
                }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).create().show();
    }
}
