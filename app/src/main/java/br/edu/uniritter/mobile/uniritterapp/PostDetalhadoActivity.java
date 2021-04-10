package br.edu.uniritter.mobile.uniritterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import br.edu.uniritter.mobile.uniritterapp.model.Post;

public class PostDetalhadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detalhado);
        Intent intent = getIntent();
        Post post = intent.getParcelableExtra("objetoPost");
        TextView userId = findViewById(R.id.userId_Post);
        userId.setText(post.getUserId() + "");
        TextView id = findViewById(R.id.id_Post);
        id.setText(post.getId() + "");
        TextView title = findViewById(R.id.title_Post);
        title.setText(post.getTitle());
        TextView body = findViewById(R.id.body_Post);
        body.setText(post.getBody());
    }
}