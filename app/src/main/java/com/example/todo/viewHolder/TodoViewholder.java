package com.example.todo.viewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todo.R;

public class TodoViewholder extends RecyclerView.ViewHolder {
    public TextView tittle,todotask,date,priority,catagory;
    public ImageView delete,edit;
    public TodoViewholder(@NonNull View itemView) {
        super(itemView);
        tittle = itemView.findViewById(R.id.tittle);
        todotask = itemView.findViewById(R.id.task);
        catagory = itemView.findViewById(R.id.catago);
        date = itemView.findViewById(R.id.date);
        priority = itemView.findViewById(R.id.priority);
        delete = itemView.findViewById(R.id.dele);
        edit = itemView.findViewById(R.id.edit);
    }
}
