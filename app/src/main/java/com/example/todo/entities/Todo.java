package com.example.todo.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_todo")
public class Todo {

    @PrimaryKey(autoGenerate = true)
    long id;
    String todotask, title, catagory, priority;

    public Todo() {
    }

    long date;

    public Todo(long id, String todotask, String title, String catagory, String priority, long date) {
        this.id = id;
        this.todotask = todotask;
        this.title = title;
        this.catagory = catagory;
        this.priority = priority;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTodotask() {
        return todotask;
    }

    public void setTodotask(String todotask) {
        this.todotask = todotask;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public Todo(String todotask, String title, String catagory, String priority, long date) {
        this.todotask = todotask;
        this.title = title;
        this.catagory = catagory;
        this.priority = priority;
        this.date = date;
    }
}