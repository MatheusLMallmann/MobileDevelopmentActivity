package br.edu.uniritter.mobile.uniritterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OptionsJson extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_json);

        Button botaoTodos = (Button) findViewById(R.id.botaoTodos);
        Button botaoPosts = (Button) findViewById(R.id.botaoPosts);
        Button botaoAlbums = (Button) findViewById(R.id.botaoAlbums);
        Button botaoComments = (Button) findViewById(R.id.botaoComments);

        botaoTodos.setOnClickListener(this::todos);
        botaoComments.setOnClickListener(this::comments);
        botaoAlbums.setOnClickListener(this::albums);
        botaoPosts.setOnClickListener(this::posts);
    }

    private void todos(View view){
        Intent intent = new Intent(this, ScrollViewTodos.class);
        startActivity(intent);
    }

    private void posts(View view){
        Intent intent = new Intent(this, ScrollViewPosts.class);
        startActivity(intent);
    }

    private void albums(View view){
        Intent intent = new Intent(this, ScrollViewAlbum.class);
        startActivity(intent);
    }

    private void comments(View view){
        Intent intent = new Intent(this, ScrollViewComment.class);
        startActivity(intent);
    }
}