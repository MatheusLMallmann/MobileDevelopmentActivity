package br.edu.uniritter.mobile.uniritterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import br.edu.uniritter.mobile.uniritterapp.model.Comment;

public class CommentDetalhadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_detalhado);
        Intent intent = getIntent();
        Comment comment = intent.getParcelableExtra("objetoComment");
        TextView postId = findViewById(R.id.postId_Comment);
        postId.setText(comment.getPostId() + "");
        TextView id = findViewById(R.id.id_Comment);
        id.setText(comment.getId() + "");
        TextView name = findViewById(R.id.name_Comment);
        name.setText(comment.getName());
        TextView email = findViewById(R.id.email_Comment);
        email.setText(comment.getEmail());
        TextView body = findViewById(R.id.body_Comment);
        body.setText(comment.getBody());
    }
}