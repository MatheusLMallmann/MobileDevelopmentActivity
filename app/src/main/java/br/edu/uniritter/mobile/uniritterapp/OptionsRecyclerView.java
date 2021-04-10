package br.edu.uniritter.mobile.uniritterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OptionsRecyclerView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_recyclerview);

        Button botaoTodos = (Button) findViewById(R.id.botaoRVTodos);
        Button botaoPosts = (Button) findViewById(R.id.botaoRVPosts);
        Button botaoAlbums = (Button) findViewById(R.id.botaoRVAlbums);

        botaoTodos.setOnClickListener(this::todos);
//        botaoPosts.setOnClickListener(this::posts);
//        botaoAlbums.setOnClickListener(this::albums);
    }

    private void todos(View view){
        Intent intent = new Intent(this, RecyclerViewTodos.class);
        startActivity(intent);
    }

//    private void posts(View view){
//        Intent intent = new Intent(this, ScrollViewPosts.class);
//        startActivity(intent);
//    }
//
//    private void albums(View view){
//        Intent intent = new Intent(this, ScrollViewAlbum.class);
//        startActivity(intent);
//    }
}