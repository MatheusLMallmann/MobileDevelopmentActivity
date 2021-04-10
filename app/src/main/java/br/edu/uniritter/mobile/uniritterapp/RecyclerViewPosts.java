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

import br.edu.uniritter.mobile.uniritterapp.adapter.PostAdapter;
import br.edu.uniritter.mobile.uniritterapp.adapter.TodoAdapter;
import br.edu.uniritter.mobile.uniritterapp.model.Post;
import br.edu.uniritter.mobile.uniritterapp.model.Todo;

public class RecyclerViewPosts extends AppCompatActivity
        implements Response.Listener<JSONArray>, Response.ErrorListener{

    public List<Post> posts = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);

        //Inicia RequestQueue
        RequestQueue queue = Volley.newRequestQueue(this);
        String urlTodos = "https://jsonplaceholder.typicode.com/posts";

        // Request de JsonArray da URL
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlTodos, null,
                this,this);

        // Adiciona a request para o RequestQueue
        queue.add(jsonArrayRequest);
    }

    @Override
    public void onResponse(JSONArray response) {
        try {
            for (int i = 0; i < response.length(); i++){
                JSONObject json = response.getJSONObject(i);
                Post objeto = new Post(json.getInt("userId"),
                        json.getInt("id"),
                        json.getString("title"),
                        json.getString("body"));

                posts.add(objeto);
            }
            RecyclerView recyclerView = findViewById(R.id.recyclerview);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(linearLayoutManager);
            PostAdapter postAdapter = new PostAdapter(posts);
            recyclerView.setAdapter(postAdapter);
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