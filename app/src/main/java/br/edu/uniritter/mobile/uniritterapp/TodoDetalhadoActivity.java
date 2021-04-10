package br.edu.uniritter.mobile.uniritterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

import br.edu.uniritter.mobile.uniritterapp.model.Todo;

public class TodoDetalhadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_detalhado);
        Intent intent = getIntent();
        Todo todo = intent.getParcelableExtra("objetoTodo");
        TextView userId = findViewById(R.id.tvIdUser);
        userId.setText(todo.getUserId() + "");
        TextView id = findViewById(R.id.tvId);
        id.setText(todo.getId() + "");
        TextView title = findViewById(R.id.tvTitle);
        title.setText(todo.getTitle());
        CheckBox completed = findViewById(R.id.cbCompleted);
        completed.setChecked(todo.isCompleted());
    }
}