package com.example.todo;

import static com.example.todo.Alert.Alert.alertdi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.todo.databinding.ActivityAddtodoBinding;
import com.example.todo.db.TodoDatabase;
import com.example.todo.entities.Todo;

public class ADDtodo extends AppCompatActivity {

    ActivityAddtodoBinding binding;
    String catagory= "Others";
    String priority="Normal";
    long dt=System.currentTimeMillis();
    String[] cata={"Education","Business","Sports","Shopping","Others"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityAddtodoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                ADDtodo.this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                cata

        );
        binding.catagory.setAdapter(adapter);
        binding.radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton=findViewById(i);

                priority=radioButton.getText().toString();
            }
        });

        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String todot=binding.addtodo.getText().toString();
                String title=binding.title.getText().toString();
                String ctg=binding.catagory.getText().toString();
                if (ctg.equals("")){
                    priority="Normal";
                }else {
                    catagory =ctg;
                }
                if (title.equals("")){
                    alertdi(ADDtodo.this,"Tittle Can't be Empty");

                }else if (todot.equals("")){
                    alertdi(ADDtodo.this,"Task Can't be Empty");
                }

                Todo todo =new Todo(todot,title,catagory,priority,dt);

                TodoDatabase.getTodoDatabase(ADDtodo.this).todo_dao().inserttodo(todo);
                Intent intent = new Intent(ADDtodo.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}