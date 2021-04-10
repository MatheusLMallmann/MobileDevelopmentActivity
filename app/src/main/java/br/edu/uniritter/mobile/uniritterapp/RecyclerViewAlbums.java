package br.edu.uniritter.mobile.uniritterapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.edu.uniritter.mobile.uniritterapp.adapter.AlbumAdapter;
import br.edu.uniritter.mobile.uniritterapp.adapter.PostAdapter;
import br.edu.uniritter.mobile.uniritterapp.adapter.TodoAdapter;
import br.edu.uniritter.mobile.uniritterapp.model.Album;
import br.edu.uniritter.mobile.uniritterapp.model.Post;
import br.edu.uniritter.mobile.uniritterapp.model.Todo;

public class RecyclerViewAlbums extends AppCompatActivity
        implements Response.Listener<JSONArray>, Response.ErrorListener{

    public List<Album> albums = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);

        //Inicia RequestQueue
        RequestQueue queue = Volley.newRequestQueue(this);
        String urlAlbums = "https://jsonplaceholder.typicode.com/albums";

        // Request de JsonArray da URL
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlAlbums, null,
                this,this);

        // Adiciona a request para o RequestQueue
        queue.add(jsonArrayRequest);
    }

    @Override
    public void onResponse(JSONArray response) {
        try {
            for (int i = 0; i < response.length(); i++){
                JSONObject json = response.getJSONObject(i);
                Album objeto = new Album(json.getInt("userId"),
                        json.getInt("id"),
                        json.getString("title"));

                albums.add(objeto);
            }
            RecyclerView recyclerView = findViewById(R.id.recyclerview);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(linearLayoutManager);
            AlbumAdapter albumAdapter = new AlbumAdapter(albums);
            recyclerView.setAdapter(albumAdapter);
        }catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        String mensagem = error.getMessage();
        Toast.makeText(this.getApplicationContext(), "Erro: " + mensagem,
                Toast.LENGTH_SHORT).show();
    }
}