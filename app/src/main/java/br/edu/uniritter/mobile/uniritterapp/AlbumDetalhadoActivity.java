package br.edu.uniritter.mobile.uniritterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import br.edu.uniritter.mobile.uniritterapp.model.Album;

public class AlbumDetalhadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_detalhado);
        Intent intent = getIntent();
        Album album = intent.getParcelableExtra("objetoAlbum");
        TextView postId = findViewById(R.id.userId_Album);
        postId.setText(album.getPostId() + "");
        TextView id = findViewById(R.id.id_Album);
        id.setText(album.getId() + "");
        TextView name = findViewById(R.id.title_Album);
        name.setText(album.getTitle());
    }
}