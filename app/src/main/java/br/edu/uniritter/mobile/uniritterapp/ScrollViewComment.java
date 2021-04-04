package br.edu.uniritter.mobile.uniritterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

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

public class ScrollViewComment extends AppCompatActivity
        implements Response.Listener<JSONArray>, Response.ErrorListener{

    List<Comment> comments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_comment);

        //Inicia RequestQueue
        RequestQueue queue = Volley.newRequestQueue(this);
        String urlComments = "https://jsonplaceholder.typicode.com/comments";

        // Request de JsonArray da URL
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, urlComments, null,
                this,this);

        // Adiciona a request para o RequestQueue
        queue.add(jsonArrayRequest);
    }

    @Override
    public void onResponse(JSONArray response) {
        try {
            for (int i = 0; i < response.length(); i++){
                JSONObject json = response.getJSONObject(i);
                Comment objeto = new Comment(json.getInt("postId"),
                        json.getInt("id"),
                        json.getString("name"),
                        json.getString("email"),
                        json.getString("body"));

                comments.add(objeto);
            }

            LinearLayout linearLayout = findViewById(R.id.linearComment);
            for (Comment objRecebido : comments){
                Button botao = new Button(this);
                botao.setText(objRecebido.getName());
                botao.setTag(objRecebido);
                botao.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Button novoBotao = (Button) v;
                        Comment comment = (Comment) novoBotao.getTag();
                        Intent intent = new Intent(getApplicationContext(), ScrollViewComment.class);

                        intent.putExtra("objetoComment", comment);
                        startActivity(intent);
                    }
                });
                linearLayout.addView(botao);
            }
        } catch (JSONException e) {
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