package com.example.todo;

import static com.example.todo.Alert.Alert.alertdi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.todo.databinding.ActivityEditactivityBinding;
import com.example.todo.db.TodoDatabase;
import com.example.todo.entities.Todo;

public class EDITActivity extends AppCompatActivity {

    ActivityEditactivityBinding binding;

    String catagory= "Others";
    String priority="Normal";
    long dt=System.currentTimeMillis();
    String[] cata={"Education","Business","Sports","Shopping","Others"};
    Intent intent;
    long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityEditactivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        intent=getIntent();
        id =intent.getLongExtra("id",013555544);


        binding.title.setText(intent.getStringExtra("tittle"));
        binding.catagory.setText(intent.getStringExtra(catagory));
        binding.addtodo.setText(intent.getStringExtra("todotask"));


        if (intent.getStringExtra("priority").equals("Low")){
            binding.low.setChecked(true);
        }else if (intent.getStringExtra("priority").equals("Default")){
            binding.defalt.setChecked(true);
        }else if (intent.getStringExtra("priority").equals("High")){
            binding.high.setChecked(true);
        }

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                EDITActivity.this,
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
                    alertdi(EDITActivity.this,"Tittle Can't be Empty");

                }else if (todot.equals("")){
                    alertdi(EDITActivity.this,"Task Can't be Empty");
                }

                Todo todo =new Todo(id,todot,title,catagory,priority,dt);

                TodoDatabase.getTodoDatabase(EDITActivity.this).todo_dao().updatetodo(todo);
                Intent intent = new Intent(EDITActivity.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}